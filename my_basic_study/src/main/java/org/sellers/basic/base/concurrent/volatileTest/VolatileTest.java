package org.sellers.basic.base.concurrent.volatileTest;

/**
 * 适用volatile的情况
 * 1.运行结果并不依赖变量的当前值，或者能够确保只有单一的线程修改变量的值。
 * 2.变量不需要与其他的状态变量共同参与不变约束。
 */
public class VolatileTest {

    private volatile static int count=0;

    /**
     * count的结果肯定会小于1000；
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int j=0;j<100;j++){
                    count++;
                    /**
                     *count++这一行代码本身并不是原子性操作，在字节码层面可以拆分成如下指令：
                     *
                     * getstatic        //读取静态变量（count）
                     * iconst_1        //定义常量1
                     * iadd               //count增加1
                     * putstatic        //把count结果同步到主内存
                     *
                     * 虽然每一次执行 getstatic 的时候，获取到的都是主内存的最新变量值，但是进行iadd的时候，
                     * 由于并不是原子性操作，其他线程在这过程中很可能让count自增了很多次。这样一来本线程所计
                     * 算更新的是一个陈旧的count值，自然无法做到线程安全；
                     */
                }
            }).start();
        }
        System.out.println("count="+count);
    }
}
