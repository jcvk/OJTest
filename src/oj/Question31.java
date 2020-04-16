package oj;

/**
 * Created by qindingkang on 2020/4/10.
 */
public class Question31 {
    public void nextPermutation(int[] nums) {

        int preKey = 0;
        int key = 0;
        int temp;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (i==0) {
                key = i;
                break;
            }

            if (nums[i - 1] < nums[i]) {
                key = i;
                preKey = i - 1;
                break;
            }
        }

        if (key != 0){
            for (int j = nums.length - 1; j >= key; j--) {

                if (nums[j] > nums[preKey]) {
                    temp = nums[preKey];
                    nums[preKey] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }

        int flag = (nums.length - key) / 2;

        for (int i = 1, j = key-1 ; i <= flag; i++) {

            temp = nums[nums.length - i];
            nums[nums.length - i] = nums[j+i];
            nums[j+i] = temp;
        }

    }


    public static void main(String[] args) {

        //int[] test = {1, 3, 6, 5, 4, 2};
        int[] test = {6, 5, 4, 3, 2, 1};
        new Question31().nextPermutation(test);
    }
}
