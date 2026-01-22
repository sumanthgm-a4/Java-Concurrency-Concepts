package org.example.futures_thread_pool_executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesAndUseCases {
    void main() {
        try (ExecutorService executor = Executors.newFixedThreadPool(1)) {

            // Use case-1: Task with Runnable - returns nothing
            Future<?> future1 = executor.submit(() -> {
                System.out.println("Task-1 with Runnable");
            });

            try {
                Object obj1 = future1.get();
                System.out.println(Objects.isNull(obj1));
            } catch (Exception e) {
                // TODO: handle exception
            }


            // Use Case-2: Task with a Runnable and a return object
            List<Integer> output = new ArrayList<>();
            Future<List<Integer>> future2 = executor.submit(() -> {
                System.out.println("Task-2 with Runnable and return object");
                output.add(42);
            }, output);

            try {
                List<Integer> obj2 = future2.get();
                System.out.println(obj2);
            } catch (Exception e) { }


            // Use Case-3: Task with a Callable - returns a value
            Future<List<Integer>> future3 = executor.submit(() -> {
                System.out.println("Task-3 with Callable");
                List<Integer> list = new ArrayList<>();
                list.add(7);
                return list;
            });

            try {
                List<Integer> obj3 = future3.get();
                System.out.println(obj3);
            } catch (Exception e) {}
        }
    }
}
