package com.example.service;

import java.util.List;
import java.util.concurrent.*;

public class LotteryService {
        private static ExecutorService pool = Executors.newFixedThreadPool(50);
    public CompletableFuture<List<Integer>> draw() {
        return CompletableFuture.supplyAsync(() -> {//higher-order function
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
            }
            System.err.println(Thread.currentThread().getName() +":drav() logic is ronning...");
            return ThreadLocalRandom.current().ints(1, 60).distinct()
                    .limit(6).sorted().boxed().toList();
        },pool);
    }

    /*
        public static List<Integer> draw(){//syn crone method
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception e){}
        return ThreadLocalRandom.current().ints(1,60).distinct()
                .limit(6).sorted().boxed().toList();
    }
    */
}
