package oj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qindingkang on 2020/4/14.
 */
public class Question54 {

    public List<Integer> spiralOrder(int[][] matrix) {


        List<Integer> result = new ArrayList<>();
        int realH = matrix.length;
        if (realH == 0) return result;
        int realW = matrix[0].length;
        int h,w;
        double min = Math.min(realH,realW);
        double time = Math.ceil(min/2);

        for (int u = 0; u < time; u++) {

            h = realH - u;
            w = realW - u;

            for (int i = u; i < w; i++) {
                result.add(matrix[u][i]);
            }

            if (u+1>=h) break;

            for (int j = u + 1; j < h; j++) {
                result.add(matrix[j][w - 1]);
            }

            for (int k = w - 2; k >= u; k--) {
                result.add(matrix[h - 1][k]);
            }

            if (w-2<u) break;

            for (int p = h - 2; p >= u + 1; p--) {
                result.add(matrix[p][u]);
            }

        }

        return result;
    }

    public static void main(String[] args) {


//        int[][] test = {
//                {1, 2, 3, 10,13},
//                {4, 5, 6, 11,14},
//                {7, 8, 9, 12,15}
//        };

//        int[][] test = {
//                {1, 2, 3,16,21},
//                {4, 5, 6,17,22},
//                {7, 8, 9,18,23},
//                {10,11,12,19,24},
//                {13,14,15,20,25}
//        };

        int[][] test = {
                {1, 2, 3,16,21},
        };

        new Question54().spiralOrder(test);

    }
}


//        for (int i = 0; i < w; i++) {
//            result.add(matrix[0][i]);
//        }
//
//        for (int j = 1; j < h; j++) {
//            result.add(matrix[j][w-1]);
//        }
//
//        for (int k = w-2; k >= 0; k--) {
//            result.add(matrix[h-1][k]);
//        }
//
//        for (int p = h-2; p >= 1; p--) {
//            result.add(matrix[p][0]);
//        }


//        int[][] test = {
//                {1, 2, 3, 10,13},
//                {4, 5, 6, 11,14},
//                {7, 8, 9, 12,15},
//                {16, 17, 18, 19,20}
//        };