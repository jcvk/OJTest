package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Jvck on 2018/3/13.
 */
public class SleepTest {

    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        int maxSize=100;
        SleepTest sleepTest=new SleepTest();
        sleepTest.new Producer(queue,maxSize,"produce").start();
        sleepTest.new Consumer("consumer",queue).start();


    }

    class Producer extends Thread{
        private Queue<Integer> queue;
        private int maxSize;
        public Producer(Queue<Integer> queue,int maxSize,String name){
            super(name);
            this.queue=queue;
            this.maxSize=maxSize;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.size()==maxSize){
                        try {
                            System.out.println("Queue is full");
                            Thread.sleep(100);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Random random=new Random();
                    int i=random.nextInt();
                    queue.add(i);
                    System.out.println("Producing value :"+i);
                }
            }
        }
    }

    class Consumer extends Thread{

        private Queue<Integer> queue;

        public Consumer(String name, Queue<Integer> queue) {
            super(name);
            this.queue = queue;
        }

        @Override
        public void run() {

            while (true){
                synchronized (queue){
                    while (queue.isEmpty()){
                        System.out.println("queue is empty");
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("consuming value "+queue.remove());
                }
            }
        }
    }
}
