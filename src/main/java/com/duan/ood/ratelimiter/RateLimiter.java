package com.duan.ood.ratelimiter;

public interface RateLimiter {
    int acquire();
    int acquire(int permits);

    double getRate();
    void setRate(double permitsPerSecond);
}
