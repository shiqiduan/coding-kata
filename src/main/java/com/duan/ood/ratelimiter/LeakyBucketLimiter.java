package com.duan.ood.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LeakyBucketLimiter {
    private double rate;
    private int water;
    private long lastTimeStamp;

    public LeakyBucketLimiter(int rate, int capacity) {
        this.rate = rate;
        this.water = capacity - 1;
    }

    public synchronized void acquire() {

    }

    public static void main(String[] args) throws InterruptedException {
        LeakyBucketLimiter limiter = new LeakyBucketLimiter(5, 10);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                limiter.acquire();
                long now = System.currentTimeMillis();
                System.out.println(limiter.water + " " + System.currentTimeMillis() / 1000);
            });
            Thread.sleep(100);
        }
        executorService.shutdown();
    }
}
