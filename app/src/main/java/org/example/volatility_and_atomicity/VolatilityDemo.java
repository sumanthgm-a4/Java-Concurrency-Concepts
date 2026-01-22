package org.example.volatility_and_atomicity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatilityDemo {
    void main() {
        final UnsafeClass obj = new UnsafeClass();
        // final SafeClassWithVolatile obj = new SafeClassWithVolatile();

        final ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                obj.loop();
            } catch (InterruptedException e) {}
        });

        executor.submit(() -> {
            obj.waitToFinish();
        });

        executor.shutdown();
    }
}
