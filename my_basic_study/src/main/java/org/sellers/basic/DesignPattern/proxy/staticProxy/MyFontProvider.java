package org.sellers.basic.DesignPattern.proxy.staticProxy;

import java.awt.*;

public class MyFontProvider {
    public static void main(String[] args) {
        FontProvider fontProvider = new ProxyFontProvider(new FontProviderFromDisk()) {
            @Override
            public String beforeDo(String deviceName) {
                System.out.println("代理前逻辑，变更deviceName");
                return deviceName + "001";
            }

            @Override
            public Font afterDo(Font font) {
                System.out.println("代理后逻辑，变更font");
                //假装变更font的逻辑
                return font;
            }
        };
        fontProvider.getFont("磁盘");
    }
}
