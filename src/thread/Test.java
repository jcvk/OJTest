package thread;

/**
 * Created by Jvck on 2018/1/30.
 */
public class Test {

    public static void main(String[] args) {
        ThreadA t1=new ThreadA("t1");

        synchronized (t1){
            try {
                System.out.println(Thread.currentThread().getName() +"  start t1");
                t1.start();//即使这里执行了start()方法 t1也没有开始执行
//                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() +"  wait()");
                t1.wait();//不是使得t1等待而是拥有t1这个对象的线程等待
                System.out.println(Thread.currentThread().getName() +"  continue");
//                t1.notify();
//                t1.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
