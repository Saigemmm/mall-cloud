package org.sellers.basic.DesignPattern.adapter.springMVC.controller.impl;

import org.sellers.basic.DesignPattern.adapter.springMVC.controller.Controller;

public class SimpleController implements Controller {
    public void doSimpleHandler(){
        System.out.println("simple...");
    }
}
