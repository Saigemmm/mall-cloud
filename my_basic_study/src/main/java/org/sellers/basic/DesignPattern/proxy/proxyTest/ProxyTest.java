package org.sellers.basic.DesignPattern.proxy.proxyTest;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        DoSomething say = new Say();
        DoSomething proxyInstance = (DoSomething) Proxy.newProxyInstance(
                say.getClass().getClassLoader(),
                say.getClass().getInterfaces(),
                (proxy, method, args1) -> method.invoke(say, args1)
        );
        proxyInstance.saySomething();
    }
}
