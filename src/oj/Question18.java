package oj;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

/**
 * Created by Jvck on 2018/3/7.
 */
public class Question18 {

    public static void main(String[] args) {
//        int[] array={2,2,2,2,4,5,9,10};
//        Question18 question18=new Question18();
//        int result= question18.findLastEqual(array,2);
//        System.out.println(result);

        try {
            int i=3;
            i=i/0;
            System.out.println(i+"gggg");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("666");
        }
    }

    void quickSort(int[] num,int start,int end){

        if (start>=end){//这个区间只有一个数就不需要递归了
            return;
        }
        int s=start;
        int e=end;
        int first=num[s];


        while (s<e){
            while (s<e&&num[e]>=first) e--;
            num[s]=num[e];
            while (s<e&&num[s]<=first) s++;
            num[e]=num[s];
        }

        num[s]=first;
        quickSort(num,start,e-1);
        quickSort(num,e+1,end);

    }

    int findFirstEqual(int[] array,int key){
        int left=0;
        int right=array.length-1;

        while (left<=right){
            int mid=(left+right)/2;

            if (array[mid]>=key){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }

        if (left<array.length&&array[left]==key){
            return left;
        }else {
            return -1;
        }
    }

    int findLastEqual(int[] array,int key){
        int left=0;
        int right=array.length-1;

        while (left<=right){
            int mid=(left+right)/2;

            if (array[mid]<=key){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }

        if (right<array.length&&array[right]==key){
            return right;
        }else {
            return -1;
        }

    }


}
