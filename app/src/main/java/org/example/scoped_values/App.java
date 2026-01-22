package org.example.scoped_values;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    ScopedValue<String> value = ScopedValue.newInstance();

    void main() {
        try (ExecutorService executor = Executors.newFixedThreadPool(1)) {
            executor.submit(() -> {
                ScopedValue.where(value, "Sample")
                    .run(() -> {
                        System.out.println(value.get());
                        method1();
                    }); 
            });
        }
    }

    void method1() {
        ScopedValue.where(value, "Method1 Value").run(() -> {
            System.out.println("Inside Method1: " + value.get());
            method2();
        });

        System.out.println(value.get());
    }

    void method2() {
        System.out.println("Inside Method2: " + value.get());
    }
}
