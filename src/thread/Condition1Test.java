package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Jvck on 2018/3/21.
 */
public class Condition1Test {

    static class BoundeBuffer{
        final Lock lock=new ReentrantLock();
        final Condition notFull=lock.newCondition();
        final Condition notEmpty=lock.newCondition();

        final Object[] items=new Object[100];
        int putptr,takeptr,count;

        public void put(Object x){
            System.out.println("put wait lock");
            lock.lock();
            System.out.println("put get lock");
            try{
                while (count==items.length){
                    System.out.println("buffer full,please wait");
                    notFull.await();
                }

                items[putptr]=x;
                if (++putptr==items.length){
                    putptr=0;
                }
                ++count;
                notEmpty.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            System.out.println("take wait lock");
            lock.lock();
            try{
                while (count==0){
                    System.out.println("no elements,please wait");
                    notEmpty.await();
                }
                Object x=items[takeptr];
                if (++takeptr==items.length){
                    takeptr=0;
                }
                --count;
                notFull.signal();
                return x;
            }finally {
                lock.unlock();
            }
        }

        public static void main(String[] args){
            final BoundeBuffer boundeBuffer=new BoundeBuffer();

            Thread t1=new Thread(() -> {
                System.out.println("t1 run");
                for (int i = 0; i <1000 ; i++) {
                        System.out.println("putting..");
                        boundeBuffer.put(i);

                }
            });

            Thread t2=new Thread(() -> {
                for (int i=0;i<1000;i++){
                    try{
                        Integer val=(Integer)boundeBuffer.take();
                        System.out.println(val);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            t1.start();
            t2.start();
        }



    }
}
