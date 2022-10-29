package com.duan.ood.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

public class GuavaRatelimiterDemo {
    private RateLimiter rateLimiter;

    public GuavaRatelimiterDemo() {
        this.rateLimiter = RateLimiter.create(10);
    }

    public void test() {
        rateLimiter.acquire();
    }
}
