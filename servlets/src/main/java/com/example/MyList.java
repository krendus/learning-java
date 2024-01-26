package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;

class Type<T> {
    T t;
    public Type() {
    }

    public Type(T t) {
        this.t = t;
    }
    public T getT() {
        return t;
    }

    @Override
    public String toString() {
        return "" + t;
    }
};


@SuppressWarnings("unchecked")
public class MyList<T> implements IMyList<T> {
    Type<T>[] dynamicList;

    public MyList() {
        Type<T> newType = new Type<>();
        Class<?> type = newType.getClass();
        dynamicList = (Type<T>[]) Array.newInstance(type, 0);
    }
    public void add(T t) {
        Type<T> newType = new Type<>();
        Class<?> type = newType.getClass();
        Type<T>[] newDynamicList;
        if(dynamicList.length > 0) {
            newDynamicList = (Type<T>[]) Array.newInstance(type, dynamicList.length + 1);
            System.arraycopy(dynamicList, 0, newDynamicList, 0, dynamicList.length);
            newDynamicList[dynamicList.length] = new Type<>(t);
        } else {
            newDynamicList = (Type<T>[]) Array.newInstance(type, 1);
            newDynamicList[0] = new Type<>(t);
        }
        this.dynamicList = newDynamicList;
    }
    public T get(int index) {
        return dynamicList[index].getT();
    }
    public int getLength() {
        return dynamicList.length;
    }

    public Object[] toArray() {
        Object[] array = new Object[dynamicList.length];
        for (int i = 0; i < dynamicList.length; i ++) {
            array[i] = dynamicList[i].getT();
        }
        return array;
    }
    public void print() {
        System.out.println(Arrays.toString(dynamicList));
    }
    public static void main(String[] args) {
        MyList<Integer> ml = new MyList<>();
        ml.add(1);
        ml.add(2);
        ml.print();

        Object[] convertedArray = ml.toArray();
        System.out.println("Printed the first item from the converted array: " +  convertedArray[0]);
        System.out.println("Printed the length of the list using the getLength method: " +  ml.getLength());
        System.out.println("Printed the first item using the get method: " +  ml.get(0));
        System.out.println("Printed the first item from the converted array: " +  ml.toArray()[0]);
        System.out.println("Printed the second item from the converted array: " +  ml.toArray()[1]);
        System.out.println("My list converted to array: " + Arrays.toString(ml.toArray()));
    }
}
