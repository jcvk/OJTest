package thread;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * Created by Jvck on 2018/3/7.
 */
public class BlockingQueueTest {

    private static final int SIZE=20;
    private ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<>(SIZE);

    public static void main(String[] args) {

        BlockingQueueTest test=new BlockingQueueTest();
        Productor productor=test.new Productor();
        Consumer consumer=test.new Consumer();

        productor.start();
        consumer.start();
    }

    class Productor extends Thread{
        @Override
        public void run() {

            while (true){
                try {
                    queue.put(1);
                    System.out.println("队列剩余空间 "+(SIZE-queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    queue.take();
                    System.out.println("队列剩余元素 "+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
