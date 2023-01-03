package com.duan.ood.ratelimiter;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Copy code from guava.
 */
public abstract class RateLimiter {

    public static RateLimiter create(double permitsPerSecond) {
        RateLimiter rateLimiter = new SmoothRateLimiter.SmoothBursty(SleepingStopwatch.createFromSystemTimer(), permitsPerSecond);
        rateLimiter.setRate(permitsPerSecond);
        return rateLimiter;
    }

    private final SleepingStopwatch stopwatch;
    private volatile Object mutexDoNotUseDirectly;

    private Object mutex() {
        Object mutex = mutexDoNotUseDirectly;
        if (mutex == null) {
            synchronized (this) {
                mutex = mutexDoNotUseDirectly;
                if (mutex == null) {
                    mutexDoNotUseDirectly = mutex = new Object();
                }
            }
        }
        return mutex;
    }

    RateLimiter(SleepingStopwatch stopwatch) {
        this.stopwatch = checkNotNull(stopwatch);
    }

    /**
     * 这里面做了什么事情呢？ 两种场景：1、启动时初始化；2、运行时修改.
     */
    public final void setRate(double permitsPerSecond) {
        checkArgument(permitsPerSecond > 0.0 && !Double.isNaN(permitsPerSecond), "rate must be positive.");
        synchronized (mutex()) {
            doSetRate(permitsPerSecond, stopwatch.readMicros());
        }
    }

    abstract void doSetRate(double permitsPerSecond, long nowMicros);

    public final double getRate() {
        synchronized (mutex()) {
            return doGetRate();
        }
    }

    abstract double doGetRate();

    public double acquire() {
        return acquire(1);
    }

    /**
     * 阻塞并获取指定数量的许可。返回阻塞时间。
     */
    public double acquire(int permits) {
        long microsToWait = reverse(permits);
        stopwatch.sleepMicrosUninterruptibly(microsToWait);
        return 1.0 * microsToWait / SECONDS.toMicros(1L);
    }


    /**
     * 收集指定数量的许可，返回需要等待到可用的时间。
     * （正常是下次可用时间，但是需要考虑桶里面保存的数量）
     */
    final long reverse(int permits) {
        checkPermits(permits);
        synchronized (mutex()) {
            return reverseAndGetWaitLength(permits, stopwatch.readMicros());
        }
    }

    final long reverseAndGetWaitLength(int permits, long nowMicros) {
        long momentAvailable = reverseEarliestAvailable(permits, nowMicros);
        return Math.max(momentAvailable - nowMicros, 0);
    }

    public boolean tryAcquire(int permits) {
        return tryAcquire(permits, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int permits, long timeout, TimeUnit unit) {
        checkPermits(permits);
        long timeoutMicros = Math.max(unit.toMicros(timeout), 0);
        long microsToWait;
        synchronized (mutex()) {
            long nowMicros = stopwatch.readMicros();
            if (!canAcquire(nowMicros, timeoutMicros)) {
                return false;
            } else {
                microsToWait = reverseAndGetWaitLength(permits, nowMicros);
            }
        }
        stopwatch.sleepMicrosUninterruptibly(microsToWait);
        return true;
    }

    protected boolean canAcquire(long nowMicros, long timeoutMicros) {
        return queryEarliestAvailable(nowMicros) - timeoutMicros <= nowMicros;
    }

    /**
     * 查询许可可用的最早时间. (跟数量无关吗？）
     * 实际返回的是下次可用时间
     */
    abstract long queryEarliestAvailable(long nowMicros);

    /**
     * 返回许可可以被使用的时间. （为什么不直接使用下次可用时间呢？）
     */
    abstract long reverseEarliestAvailable(int permits, long nowMicros);


    /**
     * 内部的时间
     */
    abstract static class SleepingStopwatch {
        protected SleepingStopwatch() {
        }

        /**
         * 获取当前时间.
         */
        protected abstract long readMicros();

        protected abstract void sleepMicrosUninterruptibly(long micros);

        public static SleepingStopwatch createFromSystemTimer() {
            return new SleepingStopwatch() {
                final Stopwatch stopwatch = Stopwatch.createStarted();

                @Override
                protected long readMicros() {
                    return stopwatch.elapsed(TimeUnit.MICROSECONDS);
                }

                @Override
                protected void sleepMicrosUninterruptibly(long micros) {
                    if (micros > 0) {
                        Uninterruptibles.sleepUninterruptibly(micros, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }
    }

    private void checkPermits(int permits) {
        checkArgument(permits > 0, "Requested permits (%s) must be positive.", permits);
    }

    public static void main(String[] args) {
        RateLimiter limiter = create(2);
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire(4));
        System.out.println(limiter.acquire(4));
        System.out.println(limiter.tryAcquire(4, 10, SECONDS));
    }
}
