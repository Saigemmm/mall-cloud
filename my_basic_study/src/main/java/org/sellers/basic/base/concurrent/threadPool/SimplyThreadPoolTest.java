package org.sellers.basic.base.concurrent.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池示例
 * 线程池的运行速度比普通线程要快得多；
 * 原因：1 普通线程创建线程和结束线程时，cpu在多个线程之间的资源切换资源消耗过大
 */
public class SimplyThreadPoolTest {
    public static void main(String[] args) {
        long start =System.currentTimeMillis();
        final Random random=new Random();
        final List<Integer> list=new ArrayList<>();
        //创建线程池
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        for (int i=0;i<10000;i++){
            executorService.execute(() -> list.add(random.nextInt()));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
            System.out.println("时间："+(System.currentTimeMillis()-start));
            System.out.println("大小："+list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
