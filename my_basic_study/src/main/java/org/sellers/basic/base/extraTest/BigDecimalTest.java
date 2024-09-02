package org.sellers.basic.base.extraTest;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal(0);
        BigDecimal zero=BigDecimal.ZERO;
        num1=num1.add(zero);
        BigDecimal num2=new BigDecimal(10.0);
        System.out.println(num1.subtract(num2));
    }

}
