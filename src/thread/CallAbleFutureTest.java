package thread;

import java.util.concurrent.*;

/**
 * Created by Jvck on 2018/3/15.
 */
public class CallAbleFutureTest {

    class CallableThreadTest implements Callable<Integer> {

        @Override
        public Integer call(){
            int sum = 0;
            for (int i = 0; i < 10000; i++) {
                if (Thread.currentThread().isInterrupted()){
                    return sum;
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        new CallAbleFutureTest().test();

    }

    private void test() throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new CallableThreadTest();


        ExecutorService service = Executors.newFixedThreadPool(2);

        //第一种启动方法
//        Future<Integer> futureTask=service.submit(callable);

        //第二种启动方法
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        service.execute(futureTask);


        int i = 0;

        while (i <= 3) {

            if (futureTask.isDone()) {//表示任务已经完成了

                if (futureTask.isCancelled()) {
                    System.out.println("任务是由于被取消了完成的");
                    System.out.println("futureTask是否已经被取消 " + futureTask.isCancelled());
                    futureTask.cancel(true);
                    System.out.println(Thread.currentThread().getName());
                    service.shutdownNow();
                } else {
                    System.out.println("任务已经完成");
                    System.out.println(futureTask.get());//然后输出结果
                }
                break;
            } else {

                System.out.println("任务还未完成");

                //任务还没有完成
                System.out.println("任务是否被取消 " + futureTask.isCancelled());

                if (i < 3) {

                    Thread.sleep(10);//主线程sleep3次50ms
                    i++;
                } else {

                    if (!futureTask.isDone()) {//判断任务是否完成了，如果任务没有完成那么就取消任务
                        System.out.println("!futureTask.isDone()");
                        futureTask.cancel(true);
                        System.out.println(Thread.currentThread().getName());


//                        try{
//                            futureTask.get();
//                        }catch (CancellationException e){
//                            e.printStackTrace();
//                            System.out.println("任务还未执行完毕，被取消");
//                        }
                    }

                }

            }
        }
        System.out.println("程序结束");


    }
}
