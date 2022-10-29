package com.duan.ood.ratelimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 设计目标：保持平均速率，允许突增速率。桶的容量即突增速率上限.
 * 参数：桶容量、同步队列作为桶、速率
 * 核心：使用同步队列来降低桶满和桶为0 的时候的边界情况的同步处理。
 * 测试：使用多线程来测试，注意覆盖的场景。
 *
 * @author shiqiduan
 */
public class TokenBucketLimiter implements RateLimiter{
    private double rate;
    private final int capacity;
    private final BlockingQueue<Integer> bucket;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public TokenBucketLimiter(int capacity, double rate) {
        this.rate = rate;
        this.capacity = capacity;
        this.bucket = new ArrayBlockingQueue<>(capacity);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            int n = (int)Math.min(rate, this.capacity - bucket.size());
            for (int i = 0; i < n; i++) {
                bucket.offer(1);
            }
            System.out.println("Add token: " + n + " qsize:" + bucket.size());
        }, 0, 1, TimeUnit.SECONDS);
    }

    @Override
    public int acquire() {
        Integer poll = bucket.poll();
        return (poll == null) ? 0 : 1;
    }

    @Override
    public int acquire(int permits) {
        List<Integer> list = new ArrayList<>();
        bucket.drainTo(list, permits);
        return list.size();
    }

    @Override
    public double getRate() {
        return this.rate;
    }

    @Override
    public void setRate(double permitsPerSecond) {
        this.rate = permitsPerSecond;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketLimiter limiter = new TokenBucketLimiter(5, 2);
        List<Runnable> tasks = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Thread.sleep(10000);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " = " + System.currentTimeMillis() / 1000);
            }
        };

        for (int i = 0; i < 50; i++) {
            int acquire = limiter.acquire(1);
            if(acquire != 0) {
                executor.execute(runnable);
            }
            Thread.sleep(200);
        }

        Thread.sleep(20000);
        System.out.println("end");
    }
}
