package org.sellers.basic.base.extraTest;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();// 获取当前时间
        // 创建SimpleDateFormat类型对象、 "yyyy-MM-dd HH:ss:mm.SSS"是正则式，分别表示年月日时分秒毫秒
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 定义初始时间
        String startTime = "2002-02-05";
        String endTime = df.format(date);
        // 将两个String类型的时间转换为Date类型，从而计算差值、parse()方法的作用是将String类型的时间解析为Date类型
        Date d1 = df.parse(startTime);
        Date d2 = df.parse(endTime);
        float a = d2.getTime() - d1.getTime();
        float b = 31536000000f;
        float c=a/b;
        DecimalFormat decimalFormat=new DecimalFormat("0.0");
        String pri=decimalFormat.format(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(pri);
    }

}
