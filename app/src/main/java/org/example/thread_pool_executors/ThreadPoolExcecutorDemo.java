package org.example.thread_pool_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExcecutorDemo {

    void main() {

        // Fixed Thread Pool

        // ExecutorService executor = Executors.newFixedThreadPool(5);

        // for (int i = 0; i < 7; i ++) {
        //     int id = i;
        //     executor.submit(() -> { 
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             // TODO Auto-generated catch block
        //             e.printStackTrace();
        //         }
        //         System.out.println("Task " + id + "running");
        //     });
        // }

        // executor.shutdown();


        // Cached Thread Pool

        // ExecutorService executor = Executors.newCachedThreadPool();

        // for (int i = 0; i < 7; i ++) {
        //     int id = i;
        //     executor.submit(() -> { 
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             // TODO Auto-generated catch block
        //             e.printStackTrace();
        //         }
        //         System.out.println("Task " + id + "running");
        //     });
        // }

        // executor.shutdown();


        // Single Thread Executor

        // ExecutorService executor = Executors.newSingleThreadExecutor();

        // for (int i = 0; i < 7; i ++) {
        //     int id = i;
        //     executor.submit(() -> { 
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             // TODO Auto-generated catch block
        //             e.printStackTrace();
        //         }
        //         System.out.println("Task " + id + "running");
        //     });
        // }

        // executor.shutdown();


        // 
    }
}
