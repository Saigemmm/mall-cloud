package org.sellers.basic.base.concurrent.reentrantLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 不可重入锁测试 CAS版
 */
public class UnReentrantTest {

    AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        for (; ; ) {
            //这句话才是加锁逻辑
             if (owner.compareAndSet(null, current)) {
                return;
            }
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }

    public static void main(String[] args) {
        UnReentrantTest unReentrantTest = new UnReentrantTest();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                unReentrantTest.lock();
                System.out.println("业务逻辑====" + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                unReentrantTest.unlock();//如果不加这行解锁代码，那么之后的999个线程都会处于无限死循环中、也即是等待锁
            }).start();
        }
    }

}
