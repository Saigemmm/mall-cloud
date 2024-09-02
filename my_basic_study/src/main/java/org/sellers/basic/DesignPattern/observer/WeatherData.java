package org.sellers.basic.DesignPattern.observer;

import lombok.Data;

import java.util.ArrayList;

/**
 * 包含最新的天气信息
 * 含有观察者集合，使用ArrayList管理
 * 当数据有更新时，就主动调用ArrayList，通知所有的接入方看到最新的消息
 */
@Data
public class WeatherData implements Subject {
    private float temperature;
    private float pressure;
    private float humidity;

    private final ArrayList<Observer> observers = new ArrayList<>();

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removerObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, pressure, humidity);
        }
    }
}
