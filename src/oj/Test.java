package oj;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Jvck on 2018/3/19.
 */
public class Test {


    private volatile BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        new Test().test();
    }

    private void test() {

        new Produce(queue).start();
        new Consumer(queue).start();
    }

    class Produce extends Thread {

        final Queue<Integer> queue;

        public Produce(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

            while (true) {

                try {
                    System.out.println("生产者添加了 " + queue.add(1) + " queue的长度为 " + queue.size());
                } catch (IllegalStateException e) {
                    System.out.println("队列满了");//这个线程暂停
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    class Consumer extends Thread {

        final Queue<Integer> queue;

        public Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {

                try{
                    System.out.println("消费者消费了 " + queue.remove() + " queue的长度为 " + queue.size());

                }catch (NoSuchElementException e){
                    System.out.println("队列为空");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
