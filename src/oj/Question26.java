package oj;

/**
 * Created by qindingkang on 2019/6/13.
 */
public class Question26 {

    public static void main(String[] args) {
        int[] sequence={};
        boolean result= new Question26().VerifySquenceOfBST(sequence);
        System.out.println("111");
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        return sequence.length != 0 && function(0, sequence.length, sequence);
    }


    public boolean function(int start, int end, int[] sequence) {
        if (start >= end) return true;
        int key = sequence[end - 1];
        boolean flag1 = false;
        int site = start;
        for (int i = start; i < end-1; i++) {
            if (sequence[i] >= key) {
                if (!flag1) {
                    site = i;
                    flag1 = true;
                }
            }
            if (sequence[i] < key) {
                if (flag1) {
                    return false;
                }
            }
        }
        return function(start, site - 1, sequence) && function(site, end - 1, sequence);
    }
}
