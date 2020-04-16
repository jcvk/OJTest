package oj;

/**
 * Created by qindingkang on 2020/4/7.
 */
public class Question42 {

    public int trap(int[] height) {

        if (height.length == 0) {
            return 0;
        }


        int temp = 0;
        int sum = 0;
        int realSum = 0;
        int length = height.length;

        int max = 0;
        for (int aHeight : height) {
            if (aHeight>max){
                max = aHeight;
            }

        }

        int level = max;

        for (int j = 0; j < level; j++) {
            for (int i = 0; i < length; i++) {
                if (height[i] > j) {
                    i++;
                    while (i < length && height[i] <= j) {
                        temp++;
                        i++;
                    }
                    i--;
                    if (i == length - 1) {//如果是最后一个
                        if (height[i] <= j) temp = 0;
                    }
                    sum = sum + temp;
                    temp = 0;
                }
            }

            realSum = realSum + sum;
            sum = 0;



        }
        return realSum;

    }

    //求每一列能容纳的水
    public int trap1(int[] height) {

        int length = height.length;
        //不用考虑两边的情况，因为是不会有水的

        int sum = 0;
        int tempSum =0 ;
        for (int i=1;i<length-1;i++){

            int leftMax = 0;
            for (int j= i-1;j>0;j--){
                leftMax = Math.max(leftMax,height[j]);
            }

            int rightMax = 0;
            for (int k= i+1;k<length;k++){
                rightMax = Math.max(rightMax,height[k]);
            }

            int min = Math.min(leftMax,rightMax);

            if (min>height[i]){
                tempSum = min-height[i];
            }
            sum = sum+tempSum;
            tempSum = 0;


        }

        return sum;

    }


    public static void main(String[] args) {

        int[] test = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        new Question42().trap(test);
    }
}
