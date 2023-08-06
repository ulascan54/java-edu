package com.example.exercise;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Exercise1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var task1 = new Task();
        var futureTask1 = new FutureTask<>(task1);
        var futureTask2 = new FutureTask<>(task1);
        new Thread(futureTask1).start(); //Stack
        new Thread(futureTask2).start(); //Stack
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println("Application is done!");
        System.out.println(task1.getCounter());
    }
}


class Task implements Callable<Integer> {
    private int counter;//Process heap

    @Override
    public Integer call() throws Exception {
        for (var i = 0; i < 10_000; ++i) counter++;
        return 42;
    }

    public int getCounter() {
        return counter;
    }
}
