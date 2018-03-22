package thread;

/**
 * Created by Jvck on 2018/3/22.
 */
public class ThreadLocalTest {

    private ThreadLocal<Long> threadId=new ThreadLocal<>();

    private void setThreadId(){
        threadId.set(Thread.currentThread().getId());
    }

    private Long getThreadId(){
        return threadId.get();
    }


    public static void main(String[] args) throws InterruptedException {

        ThreadLocalTest test=new ThreadLocalTest();

        test.setThreadId();
        System.out.println(test.getThreadId());

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                test.setThreadId();
                System.out.println(test.getThreadId());

            }
        });

        thread.start();
        thread.join();

        test.setThreadId();
        System.out.println(test.getThreadId());
    }



}
