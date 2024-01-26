package com.example;

@FunctionalInterface
interface Printer {
    String getName(String s);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Printer printer = (s) -> s;
        String name = printer.getName("This is a name");
        System.out.println(name);
    }
}


