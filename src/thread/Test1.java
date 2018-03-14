package thread;

/**
 * Created by Jvck on 2018/3/13.
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    System.out.println(Thread.currentThread().getId()+"  "+i);

                    if (i==200){
                        try {
                            System.out.println("暂停");
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread b=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j=0;j<10000;j++){
                    System.out.println(Thread.currentThread().getId()+"  "+j);
                }
            }
        });
        a.start();
        Thread.sleep(2000);
        b.start();
    }
}
