package org.jarvis.java8.factory;

/**
 * author:Lovel  date:2020/6/7
 */
public class ProductFirst implements Product {
    @Override
    public void show() {
        System.out.println("show first product");
    }

    public ProductFirst() {
        System.out.println("product first be created");
    }
}
