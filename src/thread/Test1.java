package thread;

/**
 * Created by Jvck on 2018/3/13.
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()){

                    for (int i=0;i<20;i++){
                        System.out.println("正在运行");
                    }

                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        System.out.println("抛出了中断异常");
                        System.out.println("做了一些处理");
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();

    }
}
