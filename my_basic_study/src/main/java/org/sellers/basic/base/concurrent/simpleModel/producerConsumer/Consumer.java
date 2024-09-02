package org.sellers.basic.base.concurrent.simpleModel.producerConsumer;

/**
 * 消费者实体类
 */
public class Consumer implements Runnable {
    private final ProductPool productPool;

    public Consumer(ProductPool productPool){
        this.productPool=productPool;
    }

    @Override
    public void run() {
        while (true){
            try {
                Product product=this.productPool.pull();
                System.out.println("消费者消费一件产平"+product.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
