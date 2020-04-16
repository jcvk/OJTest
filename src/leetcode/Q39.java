package leetcode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qindingkang on 2019/11/13.
 */
public class Q39 implements Serializable {

    public static void main(String[] args) {
        Q39 q39 = new Q39();
        int[] a1 = {1,2};
        List<List<Integer>> result = q39.combinationSum(a1, 4);
        System.out.println(result.toString());

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> result =combinationSum1(candidates,target);
        if (result==null){
            return new ArrayList<>();
        }else {
            return result;
        }

    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) return result;
        Arrays.sort(candidates);

        int i = length - 1;
        int temp1 = candidates[i];
        int tempSum = 0;
        while (tempSum < target) {
            List<List<Integer>> result1 = combinationSum1(Arrays.copyOf(candidates, i), target - tempSum);

            //每一个后面都加上一个当前的元素
            if (temp1 == 7) {
                System.out.println("789");
            }
            if (result1 != null) {
                if (result1.size() == 0) {//
                    if (result.size() == 0) {
                        List<Integer> temp2 = new ArrayList<>();
                        temp2.add(temp1);
                        result.add(temp2);
                    } else {
                        for (List<Integer> k : result) {
                            k.add(temp1);
                        }

                    }
                } else {
                    if (temp1 == 2) {
                        System.out.println("456");
                    }
                    int times = tempSum / temp1;
                    for (int k = 0; k < times; k++) {
                        for (List<Integer> j : result1) {
                            j.add(temp1);
                        }
                    }
                    result.addAll(result1);

                }
            }
            tempSum = tempSum + temp1;
            if (temp1 == 2) {
                System.out.println("123");
            }
        }
        if (tempSum == target) {
//            if (result.size()==0){
//                List<Integer> temp2=new ArrayList<>();
//                temp2.add(temp1);
//                result.add(temp2);
//            }

            List<List<Integer>> result67 = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();
            temp2.add(temp1);
            result.add(temp2);

            for (int l = 0; l < result.size(); l++) {
                List<Integer> temp12 = result.get(l);

                int sum = 0;
                for (int o = 0; o < temp12.size(); o++) {
                    Integer temp34 = temp12.get(o);
                    sum = sum + temp34;
                }
                if (sum != target) {
                    result.remove(temp12);
                }

            }
            for (List<Integer> temp12 : result) {
                if (!result67.contains(temp12)) {
                    result67.add(temp12);
                }

            }





//            else {
//
//                for (List<Integer> temp12:result){
//                    int sum=0;
//                    for (Integer temp34:temp12){
//                        sum=sum+temp34;
//                    }
//                    if (sum!=target){
//                        return null;
//                    }
//
//                }
//                List<Integer> temp2=new ArrayList<>();
//                temp2.add(temp1);
//                result.add(temp2);
//
//
//            }
            return result67;
        } else if (result.size() > 1) {
            return result;
        } else {
            int sum = 0;
            if (result.size() == 0) {
                return null;
            }
            for (Integer a : result.get(0)) {
                sum = a + sum;
            }
            if (sum == target) {
                return result;
            } else {
                return null;
            }
        }


    }




}
