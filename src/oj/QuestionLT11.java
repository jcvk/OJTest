package oj;

/**
 * Created by qindingkang on 2020/4/9.
 */
public class QuestionLT11 {

    //暴力求解方法
    public int maxArea(int[] height) {

        int max = Integer.MIN_VALUE;

        for (int i=0;i<height.length;i++){
            for (int j=i;j<height.length;j++){
                int h = Math.min(height[i],height[j]);
                int w = j-i;
                int size = h*w;

                max = Math.max(size,max);

            }
        }

        return max;

    }


    //双指针
    //思路：由于最大面积由两个因素控制，1：两点的距离 2：两个隔板的高度，那么可以通过控制这两个因素进行选择

    public int maxArea1(int[] height) {

        int left = 0;
        int right = height.length-1;
        int max = Integer.MIN_VALUE;
        int h;
        int size;
        while (left<right){
            if (height[left]>=height[right]){
                h=height[right];
                size = h*(right-left);
                right--;
            }else {
                h=height[left];
                size = h*(right-left);
                left++;
            }

            max = Math.max(size,max);
        }


        return max;
    }

    public static void main(String[] args) {

        //int[] test = {1,8,6,2,5,4,8,3,7};

        int[] test = {1,3};
        new QuestionLT11().maxArea1(test);
    }
}
