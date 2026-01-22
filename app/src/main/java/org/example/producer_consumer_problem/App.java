package org.example.producer_consumer_problem;

public class App {
    void main() throws InterruptedException {
        ProducerConsumerBuffer buffer = new ProducerConsumerBuffer(3);

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 6; i ++) {
                try {
                    buffer.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 6; i ++) {
                try {
                    buffer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
