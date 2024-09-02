package org.sellers.basic.DesignPattern.Singleton;

/**
 * 单例模式第一版；单例模式即是这个类始终只能创造一个对象
 * 线程不安全
 * 因为Instance是空，所以两个线程同时通过了条件判断，开始执行new操作；显然就生成了两个对象，不符合单例模式
 */
public class Singleton {
    private Singleton() {
    }//私有构造函数，防止new对象

    private static Singleton instance = null;//单例对象,懒汉模式

    /**
     * 静态工厂方法，获得这个类的对象只能通过此方法
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

