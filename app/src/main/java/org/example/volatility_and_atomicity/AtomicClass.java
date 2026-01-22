package org.example.volatility_and_atomicity;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClass {
    // private volatile int counter = 0;

    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        // counter++;
        counter.incrementAndGet();
    }

    public int get() {
        // return counter;
        return counter.get();
    }
}
