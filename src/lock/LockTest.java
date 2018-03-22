package lock;

/**
 * Created by Jvck on 2018/3/15.
 */
public class LockTest {

    class A {

        volatile int value = 0;

        public synchronized void add() {
            value = value + 1;
//            System.out.println(value);
        }

        synchronized int showValue() {
            return value;
        }
    }

    private final A a = new A();


    public static void main(String[] args) {
        new LockTest().test();

    }

    private void test() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (i < 500) {

                    a.add();
                    System.out.println(Thread.currentThread().getName() + " " + a.showValue());
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;


                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 500) {
                    a.add();
                    System.out.println(Thread.currentThread().getName() + " " + a.showValue());
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        }).start();
    }

}
