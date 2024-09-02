package org.sellers.basic.DesignPattern.Singleton;

/**
 * 利用枚举实现单例模式
 * 即可防止反射构造对象，也可保证线程安全。
 * 缺点：非懒加载，单例对象是在枚举类被加载的时候进行初始化的。
 */
public enum EnumSingleton {
    INSTANCE;
}
