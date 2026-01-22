package org.example.volatility_and_atomicity;

public class UnsafeClass {
    private boolean done = false;

    public void loop() throws InterruptedException {
        System.out.println("Entering loop method");
        for (int i = 0; i < 3; i ++) {
            Thread.sleep(1000);
        }
        System.out.println("Setting 'done' to true");
        done = true;
    }

    public void waitToFinish() {
        System.out.println("Entering waitToFinish method");
        while (!done) {
            // Busy-wait
        }
        System.out.println("Exiting waitToFinish method");
    }
}
