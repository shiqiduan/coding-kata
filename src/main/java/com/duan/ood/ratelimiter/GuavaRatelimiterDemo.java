package com.duan.ood.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GuavaRatelimiterDemo {
    private RateLimiter rateLimiter;
    private double a;

    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = RateLimiter.create(2);

        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println(limiter.acquire(4));
        System.out.println(limiter.acquire(4));
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        System.out.println(limiter.acquire(10 ));
        System.out.println(limiter.toString());

        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                System.out.println(limiter.acquire(10) + " " + System.currentTimeMillis() / 1000);
            });
        }
        Thread.sleep(10 * 1000);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                System.out.println(limiter.acquire(10) + " " + System.currentTimeMillis() / 1000);
            });
        }
        executorService.shutdown();
    }
}
