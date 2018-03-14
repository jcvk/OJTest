package thread;

/**
 * Created by Jvck on 2018/3/13.
 */
public class ThreadA extends Thread {

    public ThreadA(String name) {
        super(name);
    }


    @Override
    public void run() {

        synchronized (this){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName());
//            this.notify();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.notify();
            try {
                this.wait();
                Thread.sleep(2000);
                System.out.println("123456");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(666);
        }
    }
}
