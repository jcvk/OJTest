package oj;

/**
 * Created by Jvck on 2018/1/22.
 */
public class Question11 {

    public Question11() {


        Numberof1(10);
    }

    public void Numberof1(int n){

        System.out.println(Integer.toBinaryString(n));
        String a=Integer.toBinaryString(n);
        int count=0;
        for (int i=0;i<a.length();i++){
            if (a.charAt(i)=='1'){
                count++;
            }
        }
        System.out.println(count);

    }
}
