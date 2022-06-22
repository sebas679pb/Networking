package co.edu.escuelaing.networking;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClientMulti {
    
    public static void main(String[] args) throws IOException {
        int threads = Integer.parseInt(args[0]);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while(threads > 0){
            threads--;
            ClientRequestProcessor processor = new ClientRequestProcessor(getPort());
            threadPool.execute(processor);
        }
        threadPool.shutdown();
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt((System.getenv("PORT")));
        }
        return 35000;
    }

}
