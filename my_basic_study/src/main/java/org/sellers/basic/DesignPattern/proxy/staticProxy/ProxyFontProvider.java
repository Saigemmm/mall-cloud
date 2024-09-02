package org.sellers.basic.DesignPattern.proxy.staticProxy;

import java.awt.*;

public abstract class ProxyFontProvider implements FontProvider {
    private final FontProvider fontProvider;

    ProxyFontProvider(FontProvider fontProvider) {
        this.fontProvider = fontProvider;
    }

    @Override
    public Font getFont(String deviceName) {
        String afterName = this.beforeDo(deviceName);//代理前的逻辑
        Font font = fontProvider.getFont(afterName);//原有的逻辑
        return afterDo(font);//代理后的逻辑
    }

    public abstract String beforeDo(String deviceName);

    public abstract Font afterDo(Font font);
}
