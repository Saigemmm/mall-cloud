package org.sellers.basic.base.concurrent.simpleModel.producerConsumer;

public class TestMultiThread {
    public static void main(String[] args) {
        ProductPool productPool=new ProductPool(15);
        new Producer(productPool).start();//实例化一个生产者
        new Thread(new Consumer(productPool)).start();//实例化一个消费者
        new Consumer(productPool).run();
    }
}
