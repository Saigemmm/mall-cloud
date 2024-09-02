package org.sellers.basic.base.concurrent.threadPool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.scheduledThreadPoolExecutor();
    }

    public void primitiveThreadPoolExecutor() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                3,
                5,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5)
        );
        for (int i = 0; i < threadPool.getCorePoolSize(); i++) {
            threadPool.execute(() -> {
                for (int x = 0; x < 2; x++) {
                    System.out.println(Thread.currentThread().getName() + ":" + x);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }

    //固定线程池
    public void fixedThreadPoolExecutor() {
        //最大线程数=核心线程数=5，线程执行完立即回收——keepAliveTime为0，任务队列为默认值Integer.MAX_VALUE
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        fixedThreadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "=========>运行"));
    }

    //适用于执行定时或周期性的任务
    public void scheduledThreadPoolExecutor() {
        ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(5);
        //延迟2s执行
        scheduleThreadPool.schedule(
                () -> System.out.println(Thread.currentThread().getName() + "=========>运行"),
                2,
                TimeUnit.SECONDS
        );
        //延迟50ms后、每隔2000ms执行
        scheduleThreadPool.scheduleAtFixedRate(
                () -> System.out.println(Thread.currentThread().getName() + "=========>运行"),
                50,
                2000,
                TimeUnit.MILLISECONDS
        );
    }

    //Executors还有其他种类的线程池，这里不一一列举了，可以自行查看源码
}
