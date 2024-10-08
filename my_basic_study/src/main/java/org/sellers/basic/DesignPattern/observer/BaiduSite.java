package org.sellers.basic.DesignPattern.observer;

public class BaiduSite implements Observer {
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();
    }

    private void display(){
        System.out.println("观察者2 百度");
        System.out.println("baidu temperature:"+this.temperature);
        System.out.println("baidu pressure:"+this.pressure);
        System.out.println("baidu humidity:"+this.humidity);
    }
}
