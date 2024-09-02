package org.sellers.basic.DesignPattern.observer;

//观察者实例，可随时添加新的观察者
public interface Observer {
    void update(float temperature, float pressure, float humidity);
}
