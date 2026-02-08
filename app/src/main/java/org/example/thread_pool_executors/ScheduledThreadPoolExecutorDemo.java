package org.example.thread_pool_executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {
    void main() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        // .schedule()
        // Future<String> future1 = executor.schedule(() -> "Hello", 5, TimeUnit.SECONDS);

        // try {
        //     System.out.println(future1.get());
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } catch (ExecutionException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        // executor.shutdown();


        // .scheduleAtFixedRate()
        // Future<?> future1 = executor.scheduleAtFixedRate(() -> System.out.println("Hi"), 2, 3, TimeUnit.SECONDS);

        // try {
        //     future1.get();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } catch (ExecutionException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        // executor.shutdown();


        // .scheduleAtFixedDelay() 
        Future<?> future1 = executor.scheduleWithFixedDelay(() -> System.out.println("Hi"), 2, 3, TimeUnit.SECONDS);

        try {
            future1.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
