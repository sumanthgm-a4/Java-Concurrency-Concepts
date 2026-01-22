package org.example.futures_thread_pool_executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor {
    void main() {
        try (ThreadPoolExecutor executor = new ThreadPoolExecutor(
            3, 5, 10, TimeUnit.SECONDS, 
            new ArrayBlockingQueue<>(1),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
        )) {

            // Allow core threads to time out and terminate
            executor.allowCoreThreadTimeOut(true);

            for (int i = 0; i < 8; i ++) {
                int taskId = i;
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
                });
            }
        } 
    }
}
