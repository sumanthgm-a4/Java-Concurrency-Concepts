package org.example.virtual_threads;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

public class VirtualThreadsDemo {
    void main() throws InterruptedException {
        // Platform thread
        Thread.ofPlatform()
            .name("PlatformThread")
            .start(() -> System.out.println(Thread.currentThread()))
            .join();

        System.out.println("-------------------");

        // Virtual thread
        Thread.ofVirtual()
            .name("VirtualThread")
            .start(() -> System.out.println(Thread.currentThread()))
            .join();


        // Spin up 10000 virtual threads
        var start0 = Instant.now();
        var numThreads = 10_000;
        List<Thread> threads = IntStream.range(0,numThreads)
            .mapToObj(i -> Thread.ofVirtual().unstarted(() -> {}))
            .toList();
        threads.forEach(thread -> thread.start());
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        var end0 = Instant.now();
        System.out.println("Time taken to start and join " + numThreads + " virtual threads: " + Duration.between(start0, end0) + " ms");
    }
}
