package oj;
import java.util.Scanner;

/**
 * Created by Jvck on 2018/3/19.
 */
public class Main {

    public int solution(int num){
        int count = 0;
        while(num!=0){
            num = num & (num-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        System.out.println(new Main().solution(i));
    }
}
