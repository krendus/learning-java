package com.example;

public interface IMyList<T> {
    void add(T t);
    T get(int index);
    int getLength();
    Object[] toArray();
    public void print();
}
