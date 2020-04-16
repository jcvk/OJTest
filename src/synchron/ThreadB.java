package synchron;

/**
 * Created by qindingkang on 2019/4/8.
 */
public class ThreadB extends Thread {

    private final Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for (int i=0;i<10;i++){
                MyList.add();
                if (MyList.size()==5){
                    lock.notify();
                    System.out.println("已经发出通知了");
                }
                System.out.println("添加了"+(i+1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
