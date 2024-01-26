package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class InvokeAnyExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CallableWithException cwe = new CallableWithException();
        CallableWithoutException cwoe = new CallableWithoutException();
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(cwe);
        callables.add(cwoe);
        try {
            String result = executor.invokeAny(callables);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        executor.shutdown();
    }
}
