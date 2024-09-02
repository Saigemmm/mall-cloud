package org.sellers.basic.DesignPattern.Singleton;

/**
 * 单例模式第二版；线程安全版
 * 无法防止反射构建
 */
class DoubleCheckSingleton {
    private DoubleCheckSingleton() {
    }//私有构造方法

    /**
     * private static ThreadSingleton instance = null;
     * 这种情况可能会发生线程 A getInstance()时，当发生jvm编译器的指令重编后，instance对象还未初始化，但已不在指向null,
     * 此时如果线程B也getInstance(),执行 if（instance == null）的结果会是false，则会返回一个还未初始化的instance对象。
     */
    //volatile修饰符阻止了该变量访问前后的指令重排，保证了指令执行顺序。
    private volatile static DoubleCheckSingleton instance = null;

    /**
     * 双层检查，两次判断，在保证了 线程安全的同时也提高了执行效率。
     */
    private static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
