package org.sellers.basic.DesignPattern.factory.simpleFactory;

import org.sellers.basic.DesignPattern.factory.simpleFactory.order.OrderPizza;
import org.sellers.basic.DesignPattern.factory.simpleFactory.order.SimpleFactory;

public class PizzaBook {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
    }
}
