package org.sellers.basic.base.concurrent.simpleModel.producerConsumer;

import java.util.UUID;

/**
 * 生产者实体类
 */
public class Producer extends Thread {
    private final ProductPool productPool;

    public Producer(ProductPool productPool) {
        this.productPool = productPool;
    }

    public void run() {
        while (true) {
            String name = UUID.randomUUID() + "产品";
            System.out.println("生产者生产了产品" + name);
            Product product = new Product(name);
            try {
                this.productPool.push(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
