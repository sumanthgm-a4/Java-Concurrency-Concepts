package org.example.virtual_threads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadsWithExecutors {
    void main() {
        var begin = Instant.now();

        // Platform threads
        // try (ExecutorService executor = Executors.newFixedThreadPool(1000)) {
        //     IntStream.range(0, 1000).forEach(i -> executor.submit(() -> {
        //         try {
        //             Thread.sleep(Duration.ofSeconds(1));
        //         } catch (InterruptedException e) {
        //             throw new RuntimeException(e);
        //         }

        //         return i;
        //     }));
        // }

        // Virtual threads
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 1000).forEach(i -> executor.submit(() ->
            {
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                return i;
            }));
        }

        var end = Instant.now();

        System.out.println("Duration: " + Duration.between(begin, end) + " seconds");
    }
}
