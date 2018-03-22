package thread;

/**
 * Created by Jvck on 2018/3/15.
 */
public class JoinTest {

    class ThreadJoinTest extends Thread{

        public ThreadJoinTest(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i=0;i<1000;i++){
                System.out.println(this.getName()+" "+i);
            }
        }
    }

    public static void main(String[] args) {

        new JoinTest().test();
    }

    public void test(){

        Thread thread1= new ThreadJoinTest("第一个线程");
        Thread thread2= new ThreadJoinTest("第二个线程");

        try {
            thread1.join(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        thread2.start();


    }
}
