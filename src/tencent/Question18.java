package tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //将数组进行排序
        Arrays.sort(nums);
        //2个for循环
        List<List<Integer>> res = new ArrayList<>();
        // 最多是到倒数3个
        for (int j=0;j<nums.length-3;j++){
            if (j>0&&nums[j]==nums[j-1]) continue;
            for (int i = j+1; i < nums.length -2; i++) {
                if (i>j+1&&nums[i]==nums[i-1]) continue;// 去除掉以k开头相同的
                int l = i+1;
                int r = nums.length-1;
                while (l<r){
                    int sum = nums[i]+nums[l]+nums[r]+nums[j];
                    if (sum==target){
                        // 将数字转为List
                        res.add(new ArrayList<>(Arrays.asList(nums[j],nums[i],nums[l],nums[r])));
                        // 因为结果是不能有重复的数组，所以需要跳过相同的数组元素
                        while (l<r&&nums[l]==nums[++l]);
                        while (l<r&&nums[r]==nums[--r]);
                    }else if (sum<target){
                        while (l<r&&nums[l]==nums[++l]);
                    }else {
                        while (l<r&&nums[r]==nums[--r]);
                    }

                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test  = {-3,-1,0,2,4,5};
        new Question18().fourSum(test,2);
    }
}
