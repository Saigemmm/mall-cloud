package org.sellers.basic.DesignPattern.adapter.springMVC.adapter.impl;

import org.sellers.basic.DesignPattern.adapter.springMVC.adapter.HandlerAdapter;
import org.sellers.basic.DesignPattern.adapter.springMVC.controller.impl.AnnotationController;

public class AnnotationHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler instanceof AnnotationController;
    }

    @Override
    public void handle(Object handler) {
        ((AnnotationController) handler).doAnnotationHandler();
    }
}
