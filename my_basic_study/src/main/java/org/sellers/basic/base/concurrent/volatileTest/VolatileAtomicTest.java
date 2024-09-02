package org.sellers.basic.base.concurrent.volatileTest;

/**
 * 无法保证原子性
 */
public class VolatileAtomicTest {
    private static volatile int num = 0;
//    private static int num = 0;

    /*private static synchronized void increase() {
        num++;
    }*/

    private static void increase() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    increase();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(num);
    }
}
