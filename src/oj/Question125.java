package oj;

/**
 * Created by qindingkang on 2020/3/30.
 */
public class Question125 {

    public boolean isPalindrome(String s) {


        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (s.length() == 0){
            return true;
        }
        int length = str.length();
        int end = length -1;
        for (int i=0;i<length/2;i++,end--){
            if (str.charAt(i)!=str.charAt(end)){
                return false;
            }

        }

        return true;


    }

    public static void main(String[] args) {

        String test = "";
        new Question125().isPalindrome(test);
    }
}
