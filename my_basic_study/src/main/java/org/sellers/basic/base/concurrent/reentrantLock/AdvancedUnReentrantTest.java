package org.sellers.basic.base.concurrent.reentrantLock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 改良的不可重入锁，即将不可重入锁改写成可重入锁
 * 判断当前锁持有者是否是当前对象，采用state计数，不用每次去释放锁
 */
public class AdvancedUnReentrantTest {

    private final AtomicReference<Thread> owner = new AtomicReference<>();
    private final AtomicInteger state = new AtomicInteger(0);

    public void lock() {
        Thread current = Thread.currentThread();
        for (; ; ) {
            // 检查当前线程是否已经是锁的持有者
            if (current == owner.get()) {
                // 如果是，则增加重入次数
                int count = state.incrementAndGet();
                if (count == 1) {
                    // 如果是第一次重入（即原本未持有锁），则设置owner为当前线程
                    // 这一步在单线程环境下是多余的，因为owner已经是当前线程了
                    // 但为了保持逻辑的完整性，我们还是检查并设置它
                    owner.compareAndSet(current, current);
                }
                return;
            }
            // 如果当前线程不是锁的持有者，则尝试获取锁
            if (owner.compareAndSet(null, current)) {
                // 成功获取锁，设置重入次数为1
                state.set(1);
                return;
            }
            // 如果没有成功获取锁，则循环重试
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        // 检查当前线程是否是锁的持有者
        if (current != owner.get()) {
            throw new IllegalMonitorStateException("Thread does not own the lock");
        }
        int count = state.decrementAndGet();
        if (count == 0) {
            // 重入次数为0，表示当前线程已经完全释放了锁
            owner.compareAndSet(current, null);
        }
        // 如果count不是0，则锁仍然被当前线程持有，只是重入次数减少了
    }

    public static void main(String[] args) {
        AdvancedUnReentrantTest advancedUnReentrantTest = new AdvancedUnReentrantTest();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                advancedUnReentrantTest.lock();
                System.out.println(Thread.currentThread().getName() + "got lock");
                advancedUnReentrantTest.test++;
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                advancedUnReentrantTest.unlock();
            });
            thread.start();
        }
    }

    public int test = 1;
}
