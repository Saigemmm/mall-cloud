package org.sellers.basic.base.extraTest;

import java.util.ArrayList;
import java.util.List;

public class TryCatchTest {

    public static void main(String[] args) {
        List list = test1();
        System.out.println(list);
        System.out.println(test2());
    }

    private static List test1() {
        List list = new ArrayList<String>();
        try {
            list.add("1");
            int a = 1 / 0;
            return list;
        } catch (Exception e) {
            list.add("2");
            System.out.println("2>>>" + System.identityHashCode(list));
            return list;
        } finally {
            list.add("3");
            System.out.println("3>>>" + System.identityHashCode(list));
        }
    }

    private static int test2() {
        int a = 0;
        try {
            a = 1;
            System.out.println("1>>>" + System.identityHashCode(a));
            int i = 1 / 0;
            return a;
        } catch (Exception e) {
            a = 2;
            System.out.println("2>>>" + System.identityHashCode(a));
            return a;
        } finally {
            System.out.println("2 in finally>>>" + System.identityHashCode(a));
            a = 3;
            System.out.println("3>>>" + System.identityHashCode(a));
            a = 4;
            System.out.println("4>>>" + System.identityHashCode(a));
            a++;
            System.out.println("a++>>>" + System.identityHashCode(a));
        }
    }

}
