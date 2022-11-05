package com.duan.ood.ratelimiter;

import java.util.concurrent.*;

/**
 * 设计目标：保持平均速率，允许突增速率。桶的容量即突增速率上限.
 * 参数：桶容量、同步队列作为桶、速率
 * 核心：使用同步队列来降低桶满和桶为0 的时候的边界情况的同步处理。
 * 测试：使用多线程来测试，注意覆盖的场景。
 *
 * 问题：
 * 1、分发速度的问题，不精确
 * 2、获取的过程没有排队，无法 block 到有效值。等于实现的是block 一定时间
 *
 * @author shiqiduan
 */
public class TokenBucketLimiter {
    private double rate;
    private final int capacity;
    private final BlockingQueue<Integer> bucket;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public TokenBucketLimiter(int capacity, double rate) {
        this.rate = rate;
        this.capacity = capacity;
        this.bucket = new ArrayBlockingQueue<>(capacity);

        int gap = (int) (1000 / rate);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            int n = (int)Math.min(rate, this.capacity - bucket.size());
            for (int i = 0; i < n; i++) {
                bucket.offer(1);
            }
            System.out.println("Add token: " + n + " qsize:" + bucket.size());
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void acquire() {
        Integer poll = null;
        try {
            bucket.poll(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketLimiter limiter = new TokenBucketLimiter(4, 3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                limiter.acquire();
                System.out.println(System.currentTimeMillis() / 1000);
            });
        }
        executorService.shutdown();
    }
}
