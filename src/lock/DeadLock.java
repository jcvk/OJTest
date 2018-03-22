package lock;

import java.util.HashSet;

/**
 * Created by Jvck on 2018/3/21.
 */
public class DeadLock {

    private final String obj1="123";
    private final String obj2="456";

    public static void main(String[] args) {
        new DeadLock().test();
        HashSet<Integer> hashSet=new HashSet<>();
    }

    private void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj1){
                    try {
                        Thread.sleep(10);//这里sleep10s确保B线程能上锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2){
                        System.out.println("A线程能执行");
                        obj2.notify();//如果不执行这一步，那么线程B就一直在阻塞状态
                        //如果obj2没有执行wait方法，那么线程A执行完后，释放资源B也能正常执行
                        //但是由于B执行了wait()方法，所以A就一定手动唤醒才可以。
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj2){
                    try {
                        obj2.wait();//这里进行一个释放资源的操作
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1){
                        System.out.println("B线程能执行");
                    }
                }

            }
        }).start();
    }
}
