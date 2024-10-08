package org.sellers.basic.DesignPattern.adapter.springMVC.adapter.impl;

import org.sellers.basic.DesignPattern.adapter.springMVC.adapter.HandlerAdapter;
import org.sellers.basic.DesignPattern.adapter.springMVC.controller.impl.HttpController;

public class HttpHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler instanceof HttpController;
    }

    @Override
    public void handle(Object handler) {
        ((HttpController)handler).doHttpHandler();
    }
}

