package org.example.monitor_locks;

public class App {
    void main() throws InterruptedException {
        Sample sample = new Sample();

        Thread thread1 = new Thread(() -> sample.task1());
        Thread thread2 = new Thread(() -> sample.task2());
        Thread thread3 = new Thread(() -> sample.task3());

        thread1.start();
        Thread.sleep(500); // task1 starts before task2
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

    }
}
