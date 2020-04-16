package leetcode;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * Created by qindingkang on 2019/12/3.
 */
public class Test {

    public static String password = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";

    //public static String password = "4FFDB9A8DA94B073D5D5DC70B37FDA0E";


    public static String encryptStr(String datasource)
    {
        try
        {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(1, securekey, random);
            return new String(cipher.doFinal(datasource.getBytes("iso8859-1")), "iso8859-1");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptBinStr(String Binsrc)
    {
        try
        {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            Binsrc = BinstrToStr(Binsrc);
            return new String(cipher.doFinal(Binsrc.getBytes("UTF-8")), "UTF-8");
            //return new String(cipher.doFinal(Binsrc.getBytes()));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String result =  Test.decryptBinStr("F450B2BA21D4D6CDCE800D7E3030F96A");
        System.out.println(result);
    }

    private static String BinstrToStr(String binStr)
    {
        String[] tempStr = binStr.split("X");
        char[] tempChar = new char[tempStr.length];
        for (int i = 0; i < tempStr.length; i++) {
            tempChar[i] = BinstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }

    private static char BinstrToChar(String binStr) {
        int[] temp = BinstrToIntArray(binStr);
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += (temp[(temp.length - 1 - i)] << i);
        }
        return (char)sum;
    }
    private static int[] BinstrToIntArray(String binStr) {
        char[] temp = binStr.toCharArray();
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] -= '0';
            result[i] = temp[i];
        }
        return result;
    }
}
