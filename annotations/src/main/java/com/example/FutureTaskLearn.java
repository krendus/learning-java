package com.example;

import java.util.concurrent.*;

class RunnableTask implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("Task started...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
public class FutureTaskLearn {
    public static void main(String[] args) {
        FutureTask<String> ftOne = new FutureTask<>(new RunnableTask(), "Task 1 completed!");
        FutureTask<String> ftTwo = new FutureTask<>(new RunnableTask(), "Task 2 completed!");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(ftOne);
        executor.submit(ftTwo);
        while(true) {
            try {
                if (ftOne.isDone() && ftTwo.isDone()) {
                    System.out.println("Both task completed.");
                    executor.shutdown();
                    return;
                }
                if(!ftOne.isDone()) {
                    // this will wait synchronously
                    System.out.println("ftOne output = " + ftOne.get());
                }
                System.out.println("waiting ftTwo to complete...");
                String s = ftTwo.get(200, TimeUnit.MILLISECONDS);
                if(s != null) {
                    System.out.println("ftTwo output = " + s);
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}
