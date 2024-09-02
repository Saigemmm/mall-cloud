package org.sellers.basic.DesignPattern.proxy.proxyTest;

public class Say implements DoSomething {
    @Override
    public void saySomething() {
        System.out.println("say something...");
    }
}
