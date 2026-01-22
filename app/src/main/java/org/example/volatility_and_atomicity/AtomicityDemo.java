package org.example.volatility_and_atomicity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicityDemo {
    void main() throws InterruptedException {
        final AtomicClass obj = new AtomicClass();
        final int numThreads = 5;
        final int numIters = 10_000;

        final ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                for (int j = 0; j < numIters; j++) {
                    obj.increment();
                }
            });
        }

        executor.shutdown();
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }

        System.out.println("Final counter value: " + obj.get());
    }
}
