package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Jvck on 2018/3/9.
 */
public class InterruptTest {


     static class Test{

        private void fun1(){

        }

        private static void fun2(){

        }

        public void fun3(){

        }
    }

    class Test2 extends Test{

    }


    class CanStop extends Thread{

        private int counter=0;

        @Override
        public void run() {
            boolean done=false;

            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            while (counter<10000&&!done){
                System.out.println(counter++);

                System.out.println("isInterrupt111 "+isInterrupted());


                if (interrupted()){
                    System.out.println("isInterrupt222 "+isInterrupted());
                    try {
                        sleep(10000);
                    } catch (InterruptedException e) {
                        System.out.println("sleep的时候被打断了"+isInterrupted());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        InterruptTest test=new InterruptTest();
        final CanStop canStop=test.new CanStop();

        canStop.start();

        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                while (true){
                    try {

                        canStop.interrupt();
                        Thread.sleep(200);
                        System.out.println("interrupt333 "+canStop.isInterrupted());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        },30);
    }
}
