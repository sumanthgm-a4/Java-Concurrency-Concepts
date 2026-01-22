package org.example.monitor_locks;

public class Sample {

    public synchronized void task1() {
        System.out.println("Inside task1");
        System.out.println("Sleeping for 2 secs...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Finishing task1...");
    }

    public void task2() {
        System.out.println("Inside task2 but outside synchronized context");
        synchronized (this) {
            System.out.println("Inside synchronized block of task2");
        }
        System.out.println("Finishing task2...");
    }

    public void task3() {
        System.out.println("Inside task3 with no synchronization");
        System.out.println("Finishing task3...");
    }
}
