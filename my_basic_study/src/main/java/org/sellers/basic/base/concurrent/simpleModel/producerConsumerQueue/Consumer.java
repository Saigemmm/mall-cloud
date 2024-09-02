package org.sellers.basic.base.concurrent.simpleModel.producerConsumerQueue;

import java.util.Queue;

public class Consumer extends Thread {
    private final Queue<Integer> sharedQueue;

    Consumer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == 0) {
                    System.out.println("队列空了，等待生产");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int number = sharedQueue.poll();
                System.out.println("进行消费" + number);
                sharedQueue.notify();
            }
        }
    }
}
