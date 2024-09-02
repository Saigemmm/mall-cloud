package org.sellers.basic.DesignPattern.observer;

public class CurrentObserver implements Observer {
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
        System.out.println("观察者1");
        System.out.println("current temperature:"+this.temperature);
        System.out.println("current pressure:"+this.pressure);
        System.out.println("current humidity:"+this.humidity);
    }
}
