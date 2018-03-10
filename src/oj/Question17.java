package oj;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jvck on 2018/3/7.
 */
public class Question17 {

    public volatile AtomicInteger sum=new AtomicInteger(0);


    public void increase(){
        sum.addAndGet(1);
    }

    public static void main(String[] args) {

        Question17 question17= new Question17();
        for (int i=0;i<10;i++){
            new Thread(() -> {
                for (int j=0;j<100;j++){
                    question17.increase();
                    System.out.println(question17.sum);
                }
            }).start();
        }

        while (Thread.activeCount()>1){
            Thread.yield();
            System.out.println(Thread.activeCount());
        }

        System.out.println("jieguo"+question17.sum);
    }

    public Question17() {


    }
}
