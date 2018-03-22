package thread;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Jvck on 2018/3/15.
 */
public class ConditionTest {

    private List<Integer> list = new LinkedList<>();
    private Lock lock = new ReentrantLock();

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();


    public static void main(String[] args) throws InterruptedException {
        ConditionTest test = new ConditionTest();

        MyThread thread1 = new MyThread("线程1", test);
        MyThread thread2 = new MyThread("线程2", test);

        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        thread2.interrupt();


    }

    private void insert(Thread thread) {


        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println("响应lockInterruptedException");
        }
//        lock.lock();

        try {
            System.out.println(thread.getName() + "得到了锁");
            for (int i = 0; i < 5000; i++) {
                list.add(i);
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName() + "执行了finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }

    static class MyThread extends Thread {

        private ConditionTest test = null;

        MyThread(String name, ConditionTest test) {
            super(name);
            this.test = test;
        }

        @Override
        public void run() {

            test.insert(Thread.currentThread());


        }
    }

    private void read(Thread thread) {

        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在读取");
            }
        } finally {
            System.out.println(thread.getName() + "释放锁");
            rwl.readLock().unlock();
        }

    }
}
