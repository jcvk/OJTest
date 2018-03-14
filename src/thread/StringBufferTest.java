package thread;

/**
 * Created by Jvck on 2018/3/13.
 */
public class StringBufferTest {

    public static void main(String[] args) throws InterruptedException {

        StringBuffer str=new StringBuffer("1");

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<50;i++){
                    str.append(i);
                    System.out.println(str);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<50;i++){
                    str.append(i);
                    System.out.println(str);
                }
            }
        }).start();

        Thread.sleep(5000);

        System.out.println(str.length());



    }



}
