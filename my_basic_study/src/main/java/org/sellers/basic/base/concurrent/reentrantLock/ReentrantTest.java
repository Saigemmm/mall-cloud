package org.sellers.basic.base.concurrent.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁测试，可重入锁的意思就是该线程可重复获取锁
 * ReentrantLock和synchronized都是可重入锁
 */
public class ReentrantTest {

    ReentrantLock reentrantLock = new ReentrantLock();

    public void get() {
        reentrantLock.lock();
        System.out.println("get====" + Thread.currentThread().getName());
        set();
        reentrantLock.unlock();
    }

    public void set() {
        reentrantLock.lock();
        System.out.println("set====" + Thread.currentThread().getName());
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
        ReentrantTest reentrantTest = new ReentrantTest();
        for (; ; ) {
            new Thread(reentrantTest::get).start();
        }
    }

}
