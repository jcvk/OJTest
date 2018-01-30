package thread;

/**
 * Created by Jvck on 2018/1/30.
 */
public class Test {

    private static boolean read;
    private static int number;


    private static class TestThrad extends Thread{

        @Override
        public void run() {
            if (read){
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {



        new TestThrad().start();


        number=100;
        read=true;
    }
}
