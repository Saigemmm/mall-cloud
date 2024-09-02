package org.sellers.basic.base.concurrent.volatileTest;

import java.util.HashSet;
import java.util.Set;

/**
 * 保证有序性
 */
public class VolatileSerialTest {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(() -> {
                b = x;
                y = 1;
            });
            Thread two = new Thread(() -> {
                a = y;
                x = 1;
            });
            one.start();
            two.start();
            one.join();
            two.join();
            resultSet.add("a=" + a + "," + "b=" + b);
            System.out.println(resultSet);
        }
    }
}
