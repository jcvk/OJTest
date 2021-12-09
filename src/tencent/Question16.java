package tencent;

import java.util.Arrays;

public class Question16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sumResult = 0;
        for (int i=0;i<nums.length-2;i++){
            int start = nums[i];
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int sum = start+nums[l]+nums[r];
//                diff = Math.min(diff,Math.abs(target-sum));
                if (diff>Math.abs(target-sum)){
                    diff = Math.abs(target-sum);
                    sumResult = sum;
                }
                if (sum==target){
                    return sum;
                }else if (sum<target){
                    while (l<r&&nums[l]==nums[++l]);
                }else {
                    while (l<r&&nums[r]==nums[--r]);
                }
            }
        }
        return sumResult;
    }

    public static void main(String[] args) {
        int[] temp = {1,1,1,0};
        new Question16().threeSumClosest(temp,-100);
    }
}
