package org.sellers.basic.DesignPattern.factory.simpleFactory.pizza;

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("CheesePizza prepare.");
    }

    @Override
    public void bake() {
        System.out.println("CheesePizza prepare.");
    }

    @Override
    public void cut() {
        System.out.println("CheesePizza prepare.");
    }

    @Override
    public void box() {
        System.out.println("CheesePizza prepare.");
    }
}
