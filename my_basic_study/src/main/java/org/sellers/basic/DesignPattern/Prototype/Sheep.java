package org.sellers.basic.DesignPattern.Prototype;

/**
 * 實現Cloneable接口達到原型模式的要求
 */
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;

    //原型模式的clone方法，黨有對象的時候，clone不會創建新的，後續clone的實例該變量都會指向最初創建的對象。
    private Sheep friend;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //克隆該實例，使用默認的clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep;
        sheep = (Sheep) super.clone();
        return sheep;
    }
}
