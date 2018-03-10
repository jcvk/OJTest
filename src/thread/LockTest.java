package thread;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Jvck on 2018/3/9.
 */
public class LockTest {

    private LinkedList list=new LinkedList();
    private ReentrantLock lock=new ReentrantLock();
    private ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();

    public static void main(String[] args) {


        LockTest lockTest=new LockTest();

        new  Thread(() -> lockTest.read(Thread.currentThread())).start();

        new Thread(()-> lockTest.read(Thread.currentThread())).start();

    }

    private void insert(Thread thread){

        lock.lock();
        System.out.println(thread.getName());

        try{
            for (int i=0;i<5;i++){
                list.add(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private synchronized void get(Thread thread){

        long start=System.currentTimeMillis();

        while (System.currentTimeMillis()-start<=3){
            System.out.println(thread.getName()+"正在进行读操作");
        }

        System.out.println("读操作完毕");
    }

    private void read(Thread thread){

        rwl.readLock().lock();

        try {
            long start=System.currentTimeMillis();

            while (System.currentTimeMillis()-start<=3){
                System.out.println(thread.getName()+"正在进行读操作");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
            System.out.println("读操作完毕");
        }
    }




}
