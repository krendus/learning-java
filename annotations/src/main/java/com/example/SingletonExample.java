package com.example;

class Singleton {
    private static volatile Singleton instance;
    public String name = "Sam";

    private Singleton () {
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.name);
    }
}