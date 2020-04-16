package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qindingkang on 2019/11/11.
 */
public class Q238 {

    public static void main(String[] args) {
        Q238 q238= new Q238();
        int[] unms= {5,4,1,7,6};
        q238.productExceptSelf(unms);
    }

    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] tempA = new int[length];
        int[] tempB = new int[length];
        int[] result = new int[length];

        ArrayList a = new ArrayList();
        int start = 1;
        tempA[0] = 1;
        for (int i=1;i<length;i++){

            tempA[i]=start*nums[i-1];
            start=tempA[i];

        }

        start = 1;
        tempB[length-1] = 1;
        for (int i=length-1;i>0;i--){
            tempB[i-1] = nums[i]*start;
            start=tempB[i-1];
        }

        for (int i=0;i<length;i++){
            result[i] = tempA[i]*tempB[i];
        }


        return result;

    }

}
