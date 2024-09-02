package org.sellers.basic.base.concurrent.simpleModel;

import org.sellers.basic.base.concurrent.synchronizedTest.MainA;

public class MultiThreadTest {

    public static void main(String[] args) {
        MultiThreadTest test=new MultiThreadTest();
        test.test();
    }

    public void test() {
        MainA mainA = new MainA();
        System.out.println(Thread.currentThread().getId());
        for (int j = 1; j < 100; j++) {
            Thread thread = new Thread(() -> {
//                synchronized (this){
//                    mainA.anInt++;
//                }
                System.out.println(Thread.currentThread().getId());
            });
            thread.start();
        }
        System.out.println(mainA.anInt);
    }
}
