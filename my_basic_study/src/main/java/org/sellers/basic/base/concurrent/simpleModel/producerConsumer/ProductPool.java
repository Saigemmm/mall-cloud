package org.sellers.basic.base.concurrent.simpleModel.producerConsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * 产品池实体类
 */
class ProductPool {
    private final List<Product> productList;

    //存储所有产品的集合，生产者生产产品，从这个集合中添加元素；消费者消费产品，从这个集合的取出元素
    private Integer maxsize;

    //产品池中产品最大数量
    public ProductPool(int maxsize) {
        this.productList = new LinkedList<>();//构造产品池
        this.maxsize = maxsize;//限定产品的最大数量
    }

    /**
     * 生产者将生产好的商品放入产品池
     * 同步方法
     * 产品为临界资源
     */
    public synchronized void push(Product product) throws Exception {
        //判断是否还需要生产产品
        if (this.productList.size() == maxsize) {
            this.wait();//释放当前锁标记，使当前线程进入等待队列
        }
        //将产品添加到集合中
        this.productList.add(product);
        //通知其他人，产品可以消费，即唤醒等待this锁标记的所有线程，使这些线程进入锁池，重新开始争抢锁标记
        this.notifyAll();
    }

    /**
     * 消费者从产品池中取出商品
     */
    public synchronized Product pull() throws Exception {
        //判断是否还有商品可供消费，若为0，则释放当前锁标记，即等待生产者生产产品
        if (this.productList.size() == 0) {
            this.wait();
        }
        //从产品池中取出产品
        Product product1 = this.productList.remove(0);
        //通知生产者，消费者已经消费，即唤醒等待this锁标记的所有线程，使这些线程进入锁池，重新开始争抢锁标记
        this.notifyAll();
        return product1;
    }
}
