package org.sellers.basic.DesignPattern.proxy.proxyTest;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        DoSomething say = new Say();
        DoSomething proxyInstance = (DoSomething) Proxy.newProxyInstance(
                say.getClass().getClassLoader(),
                say.getClass().getInterfaces(),
                //proxy：代理对象，method：原来要执行的方法，args1：原来要执行的方法的参数
                (proxy, method, args1) -> {
                    System.out.println("代理前的逻辑");
                    Object result = method.invoke(say, args1);
                    System.out.println("代理后的逻辑");
                    return result;
                }
        );
        proxyInstance.saySomething();
    }
}
