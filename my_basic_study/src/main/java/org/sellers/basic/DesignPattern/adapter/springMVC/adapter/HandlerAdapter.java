package org.sellers.basic.DesignPattern.adapter.springMVC.adapter;

public interface HandlerAdapter {
    boolean supports(Object handler);

    void handle(Object handler);
}
