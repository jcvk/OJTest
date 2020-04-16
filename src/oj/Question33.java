package oj;

/**
 * Created by qindingkang on 2020/4/13.
 */
public class Question33 {

    public int search(int[] nums, int target) {
        return searchFirst(nums, 0, nums.length - 1, target);
    }

    public int searchFirst(int[] nums, int start, int end, int target) {

        if (end < start) return -1;
        int min = (end + start) / 2;
        if (nums[min] == target) return min;
        if (nums[start] < nums[min]) {//有序
            if (target >= nums[start] && target <= nums[min]) {//并且存在在有序的里面
                return fun(nums, start, min, target);
            } else {//不在前面有序的部分，在后面无须的里面
                return searchFirst(nums, min + 1, end, target);
            }

        } else {//前面是无顺序的，后面是有序的

            if (min + 1 > nums.length - 1) return -1;

            if (target >= nums[min + 1] && target <= nums[end]) {
                return fun(nums, min + 1, end, target);//并且存在在有序的里面
            } else {//不在后面有序的部分，在前面无须的里面
                return searchFirst(nums, start, min - 1, target);
            }
        }
    }

    public int fun(int[] nums, int left, int right, int target) {

        int key;
        while (left <= right) {
            key = (left + right) / 2;
            if (target == nums[key]) return key;
            if (target > nums[key]) {
                left = key + 1;
            } else {
                right = key - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] test = {4, 5, 6, 7, 0, 1, 2};

        //int[] test = {3,1};

//        for (int i=0;i<test.length;i++){
//            System.out.println(new Question33().search(test,test[i]));
//        }

        System.out.println(new Question33().search(test, 3));

    }
}
