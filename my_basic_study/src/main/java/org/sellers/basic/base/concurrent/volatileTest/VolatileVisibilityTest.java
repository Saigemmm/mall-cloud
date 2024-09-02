package org.sellers.basic.base.concurrent.volatileTest;

/**
 * 保证可见性
 */
public class VolatileVisibilityTest {

//    private static boolean initFlag = false;
    private static volatile boolean initFlag=false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("waiting data..........");
            while (!initFlag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("data success!");
        }).start();
        Thread.sleep(2000);
        new Thread(VolatileVisibilityTest::prepareData).start();
    }

    private static void prepareData() {
        initFlag = true;
        System.out.println("数据初始化成功");
    }

}
