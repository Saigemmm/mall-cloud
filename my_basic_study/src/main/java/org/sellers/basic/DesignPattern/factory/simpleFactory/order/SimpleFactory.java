package org.sellers.basic.DesignPattern.factory.simpleFactory.order;

import org.sellers.basic.DesignPattern.factory.simpleFactory.pizza.CheesePizza;
import org.sellers.basic.DesignPattern.factory.simpleFactory.pizza.GreekPizza;
import org.sellers.basic.DesignPattern.factory.simpleFactory.pizza.Pizza;

//簡單工廠模式，也叫靜態工廠模式，將createPizza改爲靜態方法即可，後續可不用new SimpleFactory
public class SimpleFactory {

    private Pizza pizza = null;

    Pizza createPizza(String PizzaType) {
        if (PizzaType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("greek");
            return pizza;
        } else if (PizzaType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("cheese");
            return pizza;
        } else {
            return pizza;
        }
    }
}
