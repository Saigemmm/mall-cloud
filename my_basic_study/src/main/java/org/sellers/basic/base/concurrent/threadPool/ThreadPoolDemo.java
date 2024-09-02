package org.sellers.basic.base.concurrent.threadPool;

import java.util.concurrent.*;

/**
 * 看三种线程池的方式执行速率
 * 三个创建方式本质上都是通过ThreadPoolExecutor的构造方法创建，只是入参不同
 * 推荐使用自定义线程，即自定义入参的ThreadPoolExecutor
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //快；创建多个线程
        //不会造成OOM，此方式只会创建多个线程，创建线程只会占CPU，最后才会导致CPU被占满，但是不会OOM
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        //当执行任务非常多时，2和3会无限创建LinkBlockingQueue，导致OOM
        //慢，相当于一次执行10个线程，所有线程按批次执行
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();//只创建了一个线程
        //自定义线程池，根据实际的业务情况自定义所需要传入的参数
        //如此定义报错，根据输出日志来判断
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10,
                20,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10));
        for (int i = 1; i <= 100; i++) {
            threadPoolExecutor.execute(new MyTask(i));
        }
    }
}

class MyTask implements Runnable {
    private int i;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--" + i);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
