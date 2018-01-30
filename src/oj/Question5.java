package oj;

/**
 * Created by Jvck on 2018/1/27.
 */
public class Question5 {


    public static void main(String[] args) {
        System.out.println(Sum_Solution(5));
    }

    public static int Sum_Solution(int n) {

        int sum=0;

        boolean b = (n > 0) && (sum = n + Sum_Solution(n - 1))==0;

        return sum;


    }
}
