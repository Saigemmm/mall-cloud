package org.sellers.basic.DesignPattern.proxy.staticProxy;

import java.awt.*;

public class FontProviderFromDisk implements FontProvider {
    @Override
    public Font getFont(String deviceName) {
        System.out.println("新建字体：" + deviceName);
        return new Font(deviceName, Font.BOLD, 10);
    }
}
