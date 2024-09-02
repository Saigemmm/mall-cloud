package org.sellers.basic.DesignPattern.adapter.springMVC.controller.impl;

import org.sellers.basic.DesignPattern.adapter.springMVC.controller.Controller;

public class HttpController implements Controller {
    public void doHttpHandler(){
        System.out.println("http...");
    }
}
