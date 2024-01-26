package com.example;


interface  MyInterface {
    String get();
    String getSecond();
}

public class InnerClass {
    public String className = "String";
    public static class StaticClass {
        public String name = "Static Internal class";
        public static String staticName = "This is a static name";
    }
    private class MemberClass {
        public String name = "Internal class";
    }

    // anonymous inner class
    MyInterface ie = new  MyInterface() {
        @Override
        public String get() {
            return "This an anonymous inner class";
        }

        @Override
        public String getSecond() {
            return "This is the second method";
        }
    };
    public void localInnerClass() {
        class LIN {
            public final String name = "Local Inner Class";
        }
        LIN lin = new LIN();
        System.out.println(lin.name);
    }
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        InnerClass.StaticClass staticClass = new InnerClass.StaticClass();
        InnerClass.MemberClass mc = innerClass.new MemberClass();
        System.out.println(mc.name);
        innerClass.localInnerClass();
        System.out.println(innerClass.ie.get());
        System.out.println(staticClass.name);
        System.out.println(InnerClass.StaticClass.staticName);
    }
}
