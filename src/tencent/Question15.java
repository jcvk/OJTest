package tencent;

import others.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question15 {

    // 遇到求2个数之和的情况下，都是需要先进行排序，然后再通过双指针进行遍历
    public List<List<Integer>> threeSum(int[] nums) {
        //将数组进行排序
        Arrays.sort(nums);
        //2个for循环
        List<List<Integer>> res = new ArrayList<>();
        // 最多是到倒数3个
        for (int i = 0; i < nums.length -2; i++) {
            if (nums[i]>0) break;//如果最小的大于0,那么不可能为0
            if (i>0&&nums[i]==nums[i-1]) continue;// 去除掉以k开头相同的
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (sum==0){
                    // 将数字转为List
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r])));
                    // 因为结果是不能有重复的数组，所以需要跳过相同的数组元素
                    while (l<r&&nums[l]==nums[++l]);
                    while (l<r&&nums[r]==nums[--r]);
                }else if (sum<0){
                    while (l<r&&nums[l]==nums[++l]);
                }else {
                    while (l<r&&nums[r]==nums[--r]);
                }

            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] temp = {-1,0,1,2,-1,-4};
        new Question15().threeSum(temp);
    }
}
