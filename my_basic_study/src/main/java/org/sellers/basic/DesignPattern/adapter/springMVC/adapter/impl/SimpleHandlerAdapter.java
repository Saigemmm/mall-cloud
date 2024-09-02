package org.sellers.basic.DesignPattern.adapter.springMVC.adapter.impl;

import org.sellers.basic.DesignPattern.adapter.springMVC.adapter.HandlerAdapter;
import org.sellers.basic.DesignPattern.adapter.springMVC.controller.impl.SimpleController;

public class SimpleHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler instanceof SimpleController;
    }

    @Override
    public void handle(Object handler) {
        ((SimpleController)handler).doSimpleHandler();
    }
}
