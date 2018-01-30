package oj;


/**
 * Created by Jvck on 2018/1/27.
 */
public class Question6 {

    public static void main(String[] args) {

        System.out.println(Add(-2,-3));
    }


    public static int Add(int num1,int num2) {


        int sign=0;
        int tempSum;
        int sum=0;
        int num=0;//num1!=0||num2!=0||sign==1
        int num31=32;
        while (num31>0){
            int a=num1&1;
            int b=num2&1;
            if ((a^b)==0){//00和11的情况

                if ((a&b)==1){//11
                    if (sign==1){
                        tempSum=1;
                        sign=1;
                    }else {
                        tempSum=0;
                        sign=1;
                    }
                }else {//00
                    if (sign==1){
                        tempSum=1;
                        sign=0;
                    }else {
                        tempSum=0;
                        sign=0;
                    }
                }
            }else {//01和10的情况
                if (sign==1){
                    tempSum=0;
                    sign=1;
                }else {
                    tempSum=1;
                    sign=0;
                }
            }

            tempSum=tempSum<<num;
            sum=sum|tempSum;
            num1=num1>>1;
            num2=num2>>1;
            num++;
            num31--;
        }
        return sum;
    }
}
