package com.example;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class ConcreteSubject implements Subject {
    private int state;
    private final List<Observer> observers = new ArrayList<>();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers ) {
            observer.update(state);
        }
    }
}

interface Observer {
    void update(int state);
}

class ConcreteObserver implements Observer {
    private final String observerName;

    public ConcreteObserver(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(int state) {
        System.out.println(observerName + " new state: " + state);
    }
}

public class ObserverExample {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("ob1");
        Observer observer2 = new ConcreteObserver("ob2");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.setState(45);
    }
}
