package com.example;

import java.util.concurrent.*;

class SampleCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 5;
    }
}
public class LearnConcurrency {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new SampleCallable());
        System.out.println("Waiting for result...");
        Integer result = future.get();
        System.out.println(result);
        executor.shutdown();
    }
}
