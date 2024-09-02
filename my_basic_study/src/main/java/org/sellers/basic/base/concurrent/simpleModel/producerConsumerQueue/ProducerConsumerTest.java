package org.sellers.basic.base.concurrent.simpleModel.producerConsumerQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Queue<Integer> sharedQueue=new LinkedList<>();
        Thread producer=new Producer(sharedQueue);
        Thread consumer=new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }
}
