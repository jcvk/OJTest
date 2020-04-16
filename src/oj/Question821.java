package oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qindingkang on 2019/3/16.
 */
public class Question821 {

    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            for (int j = i, k = i - 1;; j++, k--) {
                if (j < S.length()) {
                    char tempR = S.charAt(j);
                    if (tempR == C) {
                        result[i] = j - i;
                        break;
                    }
                }

                if (k >= 0) {
                    char tempL = S.charAt(k);
                    if (tempL == C) {
                        result[i] = i - k;
                        break;
                    }
                }


            }
        }
        return result;

    }

    public static void main(String[] args) {
        String S = "abaa";
        char C = 'b';
        int[] result = new Question821().shortestToChar(S, C);

    }
}
