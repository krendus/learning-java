package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class CallableWithoutException implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Success";
    }
}
class CallableWithException implements Callable<String> {

    @Override
    public String call() throws Exception {
        throw new Exception("Custom error");
    }
}
public class InvokeExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CallableWithException cwe = new CallableWithException();
        CallableWithoutException cwoe = new CallableWithoutException();
        CallableWithoutException cwoe2 = new CallableWithoutException();
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(cwoe);
        callables.add(cwoe2);
        callables.add(cwe);
        try {
            List<Future<String>> futures = executor.invokeAll(callables);
            for (Future<String> future:futures) {
               String result = future.get();
               System.out.println(result);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception: " + e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("Execution exception: " + e.getMessage());
        }
        executor.shutdown();
    }
}
