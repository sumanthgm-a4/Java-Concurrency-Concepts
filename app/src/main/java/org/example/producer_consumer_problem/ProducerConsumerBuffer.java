package org.example.producer_consumer_problem;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerBuffer {
    private Queue<Integer> sharedBuffer;
    private Integer capacity;

    public ProducerConsumerBuffer(Integer capacity) {
        this.sharedBuffer = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void produce(Integer item) throws InterruptedException {
        System.out.println("Producing an item...");
        while (sharedBuffer.size() == capacity) {
            System.out.println("Buffer is full, producer is waiting...");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced an item: " + item);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        System.out.println("Consuming an item...");
        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty, consumer is waiting...");
            wait();
        }
        Integer item = sharedBuffer.poll();
        System.out.println("Consumed an item: " + item);
        notify();
    }
}
