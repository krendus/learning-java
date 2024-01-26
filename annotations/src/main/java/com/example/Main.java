package com.example;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.stream.IntStream;
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name();
    double version();
}
@Retention(RetentionPolicy.RUNTIME)
@interface MySecondAnnotation {
    String name();
    double version();
}
/**
 * @author Samuel
 * @since 1.0
 */

@MyAnnotation(name = "Samuel", version = 1.0)
@MySecondAnnotation(name = "Samuel Two", version = 2.0)
public class Main {
    String name = "dfsdf";
    public static void main(String[] args) {
        Main mn = new Main();
        Class<?> cla = mn.getClass();
        Annotation[] annotations =  cla.getAnnotations();
        for (Annotation ann: annotations) {
            if(ann instanceof MyAnnotation) {
                System.out.println("Name: " + ((MyAnnotation) ann).name());
                System.out.println("Version: " + ((MyAnnotation) ann).version());
            }
            if(ann instanceof MySecondAnnotation) {
                System.out.println("Name: " + ((MySecondAnnotation) ann).name());
                System.out.println("Version: " + ((MySecondAnnotation) ann).version());
            }
        }
    }
}