package org.sellers.basic.DesignPattern.adapter.springMVC.controller.impl;

import org.sellers.basic.DesignPattern.adapter.springMVC.controller.Controller;

public class AnnotationController implements Controller {
    public void doAnnotationHandler() {
        System.out.println("annotation...");
    }
}