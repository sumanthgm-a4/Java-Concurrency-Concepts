package org.example.completable_futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> result = task1.thenCombine(task2, (i, s) -> i + s);

        try {
            System.out.println(result.get());
        } catch(Exception e) {}

    }
}
