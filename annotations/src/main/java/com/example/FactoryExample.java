package com.example;

interface Product {
    void doSomething();
}
class ConcreteProduct implements Product {

    @Override
    public void doSomething() {
        System.out.println("Concrete Product is doing something...");
    }
}
class Factory {
     public static Product createProduct() {
        return new ConcreteProduct();
    }
}

public class FactoryExample {
    public static void main(String[] args) {
        Product product = Factory.createProduct();
    }
}
