package org.example.virtual_threads;

public class ThreadBuilderDemo {
    void main() throws InterruptedException {
        System.out.println(Thread.currentThread().isVirtual());

        Thread thread = Thread.ofVirtual()
            .name("Thread1")
            .start(() -> System.out.println(Thread.currentThread().getName() + Thread.currentThread().isVirtual()));

        thread.join();
    }
}
