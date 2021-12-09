package tencent;

public class Question27 {

    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int num : nums) {
            if (num!=val){
                nums[ans] = num;
                ans++;
            }
        }
        return ans;

    }
}
