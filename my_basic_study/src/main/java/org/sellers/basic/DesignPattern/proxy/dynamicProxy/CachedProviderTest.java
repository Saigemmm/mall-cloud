package org.sellers.basic.DesignPattern.proxy.dynamicProxy;

import org.sellers.basic.DesignPattern.proxy.staticProxy.FontProvider;
import org.sellers.basic.DesignPattern.proxy.staticProxy.FontProviderFromDisk;

import java.lang.reflect.Proxy;

public class CachedProviderTest {
    public static void main(String[] args) {
        FontProvider realFontProvider = new FontProviderFromDisk();
        FontProvider proxyInstance = (FontProvider) Proxy.newProxyInstance(
                realFontProvider.getClass().getClassLoader(),
                realFontProvider.getClass().getInterfaces(),
                new CachedProviderHandler(realFontProvider)
        );
        proxyInstance.getFont("动态代理的字体名字");
    }
}
