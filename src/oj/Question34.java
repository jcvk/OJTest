package oj;

import java.util.Arrays;

/**
 * Created by qindingkang on 2020/4/14.
 */
public class Question34 {
    public int[] searchRange(int[] nums, int target) {


        int left = 0;
        int right = nums.length-1;
        int mid;
        int position=0;

        int[] result = new int[2];
        result[1]  = nums.length-1;

        while (left<=right){
            mid = (left+right)/2;

            if (nums[mid]==target){
                position = mid;
                break;
            }

            if (nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        if (left>right) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        for (int i=position;i>=0;i--){
            if (nums[i]!=target){
                result[0] = i+1;
                break;
            }
        }

        for (int i=position;i<nums.length;i++){
            if (nums[i]!=target){
                result[1] = i-1;
                break;
            }
        }
        return result;

    }

    public static void main(String[] args) {

        int[] test = {5,7,7,8,8,10};
        for (int i=0;i<=10;i++){
            System.out.println(Arrays.toString(new Question34().searchRange(test, i)));
        }
        //new Question34().searchRange(test,10);
    }
}
