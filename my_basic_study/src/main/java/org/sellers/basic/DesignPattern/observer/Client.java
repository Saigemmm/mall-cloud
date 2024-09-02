package org.sellers.basic.DesignPattern.observer;

public class Client {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        CurrentObserver currentObserver=new CurrentObserver();
        BaiduSite baiduSite=new BaiduSite();
        weatherData.registerObserver(currentObserver);
        weatherData.registerObserver(baiduSite);
        weatherData.setData(36f,140f,12.3f);
    }
}
