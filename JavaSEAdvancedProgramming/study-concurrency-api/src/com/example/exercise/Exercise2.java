package com.example.exercise;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Exercise2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var threadPool = Executors.newCachedThreadPool();//burst işlemler
        threadPool.execute(()->{
            System.err.println("Hello world");
        });
        var future = threadPool.submit(()->{
            return 42;
        });

        System.out.println(future.get());
        //Executors.newFixedThreadPool(100);
        //Executors.newFixedThreadPool(10*Runtime.getRuntime().availableProcessors());
        //Executors.newSingleThreadExecutor() -> bulk işlemler
        //Executors.newScheduledThreadPool()
    }
}
