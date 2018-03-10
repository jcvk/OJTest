package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Jvck on 2018/2/22.
 */
public class TaskExecutionWebServer {

    private static final int NTHREADS=10;
    private static final Executor exce= Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket=new ServerSocket(81);

        while (true){
            final Socket connection=socket.accept();
            Runnable task=new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };

            exce.execute(task);
        }
    }

    private static void handleRequest(Socket connection) {
    }

}
