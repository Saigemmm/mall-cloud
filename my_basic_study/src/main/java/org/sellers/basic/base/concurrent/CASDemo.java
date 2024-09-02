package org.sellers.basic.base.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class CASDemo {
    final AtomicReference<Integer> integer = new AtomicReference<>(0);

    public void increment() {
        while (true) {
            Integer expectation = this.integer.get();
            Integer update = expectation + 1;
            if (integer.compareAndSet(expectation, update)) break;
        }
    }

    public static void main(String[] args) {
        CASDemo cas = new CASDemo();
        for (int i = 0; i < 10000; i++) {
            new Thread(cas::increment).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cas.integer.get());
    }
}
