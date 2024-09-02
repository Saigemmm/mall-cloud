package org.sellers.basic.base.concurrent.simpleModel.producerConsumer;

/**
 * 产品实体类
 */
public class Product {
    private String name;

    Product(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
