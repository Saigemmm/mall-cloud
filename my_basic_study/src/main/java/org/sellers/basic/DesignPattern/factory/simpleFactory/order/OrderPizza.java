package org.sellers.basic.DesignPattern.factory.simpleFactory.order;

import org.sellers.basic.DesignPattern.factory.simpleFactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    public OrderPizza(SimpleFactory simpleFactory) {
        setSimpleFactory(simpleFactory);
    }

    //聚合的方式
    private void setSimpleFactory(SimpleFactory simpleFactory) {
        String pizzaType = "";
        //組合的方式
        //SimpleFactory simpleFactory=new SimpleFactory();
        do {
            pizzaType = getPizzaType();
            Pizza pizza = simpleFactory.createPizza(pizzaType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("創建失敗");
                break;
            }
        } while (true);
    }

    private String getPizzaType() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza type:");
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
