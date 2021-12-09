package tencent;

import java.util.Arrays;

public class Question31 {

    //1.我们希望获取下一个数比当前大，因此只需要将后面的大数与前面的小数进行交换
    //2.我们希望增幅最小
    // a.尽可能靠右的地位进行交换，需要从后往前找
    // b.尽可能找小的大数与前面的小数进行交换
    // c.将大数换到前面之后，需要将大数后面的所有数设置为升序，升序就是最小的排列
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i-1]<nums[i]){
                for (int j = nums.length-1; j > i-1; j--) {
                    // 将j和i-1进行交换
                    if (nums[j]>nums[i-1]){
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        // 交换完成之后，[i,end]是逆序的，现在需要变为升序
                        // 这里的排序算法可以优化
                        int end = nums.length-1;
                        int half = (end-i)/2;
                        for (int k = 0; k <= half; k++) {
                            int temp1 = nums[i+k];
                            nums[i+k] = nums[end-k];
                            nums[end-k] = temp1;
                        }
//                        Arrays.sort(nums,i,nums.length);
                        return;
                    }
                }
            }

        }
        Arrays.sort(nums);
    }



    public static void main(String[] args) {
        int[] test = {4,6,5,3,2};
        new Question31().nextPermutation(test);

    }


}
