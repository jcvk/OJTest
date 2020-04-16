package oj;

/**
 * Created by qindingkang on 2019/6/12.
 */
public class Question24 {

    public static void main(String[] args) {
        int[] pushA = {1};
        int[] popA = {2};
        new Question24().IsPopOrder(pushA, popA);
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int key = popA[0];
        int tempSize = -1;
        int[] temp = new int[pushA.length];
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == key) {
                tempSize = i;
                break;
            }
            temp[i] = pushA[i];
        }
        int j = tempSize;
        if (j==-1){
            return false;
        }
        if (j==0){
            return true;
        }
        for (int i = 0; i < popA.length; i++) {
            if (popA[i] == temp[j - 1]) {
                j--;
                if (j == 0) {
                    return true;
                }
            }
        }
        return j == 0;


    }
}
