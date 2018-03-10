package oj;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Jvck on 2018/3/5.
 */
public class Question16 {

    public static void main(String[] args) {

        System.out.println(Power(2,-3));

        ArrayList<Integer> test=new ArrayList<>();

    }


    public static double Power(double base, int exponent) {

        double sum=1;

        if(exponent<0){
            base=1.0/base;
        }

        if(exponent<0){
            exponent=0-exponent;
        }

        for(int i=0;i<exponent;i++){

            sum=sum*base;
        }

        return sum;
    }
}
