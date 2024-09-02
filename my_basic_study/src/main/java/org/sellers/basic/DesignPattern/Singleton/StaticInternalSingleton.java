package org.sellers.basic.DesignPattern.Singleton;

/**
 * 静态内部类实现单例模式
 * 无法防止反射
 */
public class StaticInternalSingleton {
    /**
     * 静态内部类，利用classloader的加载机制来实现懒加载，并保证构建单例的线程安全。
     * 静态内部类，在只有外部类被加载的情况下静态内部类是不会被加载的，实现了懒加载
     * JVM在装在类的时候是线程安全的。
     */
    private static class lazyHolder {
        //静态变量只有在第一次加载类的时候初始化
        private static final StaticInternalSingleton INSTANCE = new StaticInternalSingleton();
    }

    private StaticInternalSingleton() {
    }

    public static StaticInternalSingleton getInstance() {
        return lazyHolder.INSTANCE;
    }
}
