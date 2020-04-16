package oj;

import java.util.Objects;
import java.util.Scanner;

/**
 * Created by qindingkang on 2019/3/30.
 */
public class Question98 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        if (Objects.equals(str, "")){
            System.out.println("true");
            return;
        }
        String[] arr=str.split(",");
        int[] ints=new int[arr.length];
        for (int i=0;i<ints.length;i++){
            if (arr[i]==""){
                System.out.println("false");
                return;
            }
            ints[i]=Integer.parseInt(arr[i]);
        }
        if (new Question98().solution(ints)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

    private boolean solution(int[] list){
        for (int i=0,j=0;i<list.length;i++){
            if (i+j+1<list.length){//没有超出边界
                if (list[i]<list[i+j+1]){
                    return false;
                }
            }
            if (i+j+2<list.length){
                if (list[i]>list[i+j+2]){
                    return false;
                }
            }
            j++;

        }
        return true;
    }

}
