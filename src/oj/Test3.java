package oj;

/**
 * Created by qindingkang on 2020/1/30.
 */
public class Test3 {

    public static void main(String[] args) {
        int time = 1;
        int sum =10;
        while (sum!=30){
            sum=10;
            sum+=time*9-(10-time);
            time++;
        }
        System.out.println(--time);

    }


}
