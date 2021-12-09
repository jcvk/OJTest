package tencent;

public class Question26 {

    public int removeDuplicates(int[] nums) {

        if (nums.length==0) return 0;
        int new_index = 1;
        int last = nums[0];
        for (int i = 1; i <nums.length; i++) {
            // 如果后面的元素和前面的元素一样就跳过
            if (nums[i] != last) {
                nums[new_index] = nums[i];
                last = nums[i];
                new_index++;
            }
        }
        return new_index;
    }

    public static void main(String[] args) {
        int[] test = {0,0,1,1,1,2,2,3,3,4};
        new Question26().removeDuplicates(test);
    }
}
