package tencent;

public class Question33 {

    public int search(int[] nums, int target) {

        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid]==target) return mid;
            // 向前规约的条件
            if (nums[0] <= target && target <= nums[mid]) {
                right = mid - 1;

            }else if (nums[0] > nums[mid] && target >= nums[0]) {
                right = mid - 1;

            }else if (nums[0] > nums[mid] && target <= nums[mid]) {
                right = mid - 1;

            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        for (int num : nums) {
            int res = new Question33().search(nums,0);
            System.out.println(res+"");
        }


    }
}
