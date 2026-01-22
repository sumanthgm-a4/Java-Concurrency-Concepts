package org.example.thread_local;

public class ThreadLocalDemo {
    
    private static final ThreadLocal<String> session = ThreadLocal.withInitial(() -> null);

    void main() throws InterruptedException {
        Thread t1 = Thread.ofPlatform().name("T1").start(() -> {
            // Access the ThreadLocal variable to set a username in its own "session"
            session.set("UserA");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Access the ThreadLocal variable to get the value
            System.out.println(Thread.currentThread().getName() + " : " + session.get());

            // Clean up the ThreadLocal variable
            session.remove();
        });

        Thread t2 = Thread.ofPlatform().name("T2").start(() -> {
            // Access the ThreadLocal variable to set a username in its own "session"
            session.set("UserB");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Access the ThreadLocal variable to get the value
            System.out.println(Thread.currentThread().getName() + " : " + session.get());

            // Clean up the ThreadLocal variable
            session.remove();
        });

        t1.join();
        t2.join();

    }
}
