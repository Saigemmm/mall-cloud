package org.sellers.basic.base.concurrent.reentrantLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 改良的不可重入锁，即将不可重入锁改写成可重入锁
 * 判断当前锁持有者是否是当前对象，采用state计数，不用每次去释放锁
 *
 */
public class AdvancedUnReentrantTest {

    private final AtomicReference<Thread> owner = new AtomicReference<>();
    private int state = 0;

    public void lock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            state++;
            return;
        }
        for (; ; ) {
            if (owner.compareAndSet(null, current)) {
                System.out.println("业务逻辑====" + current.getName());
                return;
            }
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            state--;
        } else {
            owner.compareAndSet(current, null);
        }
    }

    public static void main(String[] args) {
        AdvancedUnReentrantTest advancedUnReentrantTest=new AdvancedUnReentrantTest();
        advancedUnReentrantTest.lock();
        advancedUnReentrantTest.lock();
    }

}
