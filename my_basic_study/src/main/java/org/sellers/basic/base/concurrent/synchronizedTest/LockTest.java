package org.sellers.basic.base.concurrent.synchronizedTest;

public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        MainA a = new MainA();
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                a.increase();
            }
        });
        thread1.start();
        for (int i = 0; i < 100000; i++) {
            a.increase();
        }
        thread1.join();
        long end = System.currentTimeMillis();
        System.out.printf("%sms%n", end - start);
        System.out.println(a.getAnInt());
    }

}
