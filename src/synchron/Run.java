package synchron;

/**
 * Created by qindingkang on 2019/4/8.
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        ThreadA threadA=new ThreadA(lock);
        threadA.start();
        Thread.sleep(1000);
        ThreadB threadB=new ThreadB(lock);
        threadB.start();
    }

}
