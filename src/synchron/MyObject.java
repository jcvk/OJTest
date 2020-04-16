package synchron;

/**
 * Created by qindingkang on 2019/4/8.
 */
public class MyObject{
    synchronized public void methodA() throws InterruptedException {
        System.out.println("A");
    }

    synchronized public void methodB() throws InterruptedException {
        System.out.println("B");
    }
}
