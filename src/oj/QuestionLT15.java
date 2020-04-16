package oj;

import utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qindingkang on 2020/4/10.
 */
public class QuestionLT15 {

    //这是从一个元素的两边取查找，去重复不方便
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length == 0) return null;

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int left;
        int right;
        int sumTemp;
        for (int i = 1; i < nums.length - 1; i++) {

            left = i - 1;
            right = i + 1;

            while (left >= 0 && right < nums.length) {
                sumTemp = nums[left] + nums[i] + nums[right];
                if (sumTemp == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[left]);
                    item.add(nums[i]);
                    item.add(nums[right]);
                    result.add(item);
                }
                if (sumTemp > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return result;

    }


    public List<List<Integer>> threeSum1(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int left,right,sumTemp;

        for (int i=0;i<nums.length;i++){

            if (nums[i]>0){
                return result;
            }
            if (i>0&&nums[i]==nums[i-1]) continue;

            left = i+1;
            right = nums.length - 1;
            while (left<right){
                sumTemp = nums[left] + nums[i] + nums[right];
                if (sumTemp == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[left]);
                    item.add(nums[i]);
                    item.add(nums[right]);
                    result.add(item);

                    while (left<right&&nums[left]==nums[left+1]) left++;
                    while (left<right&&nums[right]==nums[right-1]) right--;

                    left++;
                    right--;
                }else if (sumTemp >0){
                    right--;
                }else {
                    left++;
                }

            }
        }



        return result;
    }


    public static void main(String[] args) {

        int[] test = {1, -1, 1, -1, 0, 0};

        //int[] test = {0, 0,  0, 0};

        new QuestionLT15().threeSum1(test);
    }


}
