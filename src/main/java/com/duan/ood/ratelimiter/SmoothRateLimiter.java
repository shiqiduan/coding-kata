package com.duan.ood.ratelimiter;

import com.google.common.math.LongMath;

import static java.lang.Math.min;
import static java.util.concurrent.TimeUnit.SECONDS;

abstract class SmoothRateLimiter extends RateLimiter {

    static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        SmoothBursty(SleepingStopwatch stopwatch, double maxBurstSeconds) {
            super(stopwatch);
            this.maxBurstSeconds = maxBurstSeconds;
        }

        @Override
        void doSetRate(double permitsPerSecond, double stableIntervalMicros) {
            double oldMaxPermits = this.maxPermits;
            maxPermits = maxBurstSeconds * permitsPerSecond;
            if (oldMaxPermits == Double.POSITIVE_INFINITY) {
                // if we don't special-case this, we would get storedPermits == NaN, below
                storedPermits = maxPermits;
            } else {
                storedPermits =
                        (oldMaxPermits == 0.0)
                                ? 0.0 // initial state
                                : storedPermits * maxPermits / oldMaxPermits;
            }
        }

        @Override
        protected long storedPermitsToWaitTime(double storedPermits, double storedPermitsToSpend) {
            return 0;
        }

        @Override
        double coolDownIntervalMicros() {
            return stableIntervalMicros;
        }
    }

    /**
     * 当前桶里面的水位
     */
    double storedPermits;
    /**
     * 桶的大小. 允许的峰值？？？
     */
    double maxPermits;
    /**
     * 两个令牌之间的固定间隔. 核心速率的控制逻辑
     */
    double stableIntervalMicros;
    /**
     * 下次请求可用的时间. 不用关系请求的许可数量. 获取后，下一个请求为此支付延迟时间.
     * 也就是说，当前这个时间可用的话，请求可以立刻返回。然后，修改为下次可用的时间.
     * 需要考虑桶的存储能力
     */
    private long nextFreeTicketMicros;

    SmoothRateLimiter(SleepingStopwatch stopwatch) {
        super(stopwatch);
    }

    /**
     * 这里的核心设计是啥？？？
     */
    @Override
    void doSetRate(double permitsPerSecond, long nowMicros) {
        resync(nowMicros);
        double stableIntervalMicros = SECONDS.toMicros(1L) / permitsPerSecond;
        this.stableIntervalMicros = stableIntervalMicros;
        doSetRate(permitsPerSecond, stableIntervalMicros);
    }

    abstract void doSetRate(double permitsPerSecond, double stableIntervalMicros);

    @Override
    double doGetRate() {
        return SECONDS.toMicros(1l) / stableIntervalMicros;
    }

    /**
     * 返回下次可用时间, 不需要先 resync 吗?
     */
    @Override
    long queryEarliestAvailable(long nowMicros) {
        return nextFreeTicketMicros;
    }

    @Override
    long reverseEarliestAvailable(int requiredPermits, long nowMicros) {
        resync(nowMicros);
        long returnValue = nextFreeTicketMicros;
        // 修改下次可用的时间
        double storedPermitsToSpend = Math.min(requiredPermits, storedPermits);
        double freshPermits = requiredPermits - storedPermitsToSpend;
        long waitMicros =
                storedPermitsToWaitTime(this.storedPermits, storedPermitsToSpend)
                        + (long) (freshPermits * stableIntervalMicros);

        this.nextFreeTicketMicros = LongMath.saturatedAdd(nextFreeTicketMicros, waitMicros);
        this.storedPermits -= storedPermitsToSpend;
        return returnValue;
    }

    /**
     * 将一部分桶里面的令牌转成时间 ？？？
     */
    protected abstract long storedPermitsToWaitTime(double storedPermits, double storedPermitsToSpend);

    /**
     * 冷却时间间隔. 默认是固定的令牌时间，允许扩展冷却的算法.
     */
    abstract double coolDownIntervalMicros();

    /**
     * 基于当前时间修改桶的水位和下次可用时间. 每次都要调用一下修正数据.
     */
    void resync(long nowMicros) {
        // 如果下次时间已经过去了，则修正桶的水位和下次可用的时间.
        if (nowMicros > nextFreeTicketMicros) {
            // 两次请求，新产出的令牌数量.
            double newPermits = (nowMicros - nextFreeTicketMicros) / coolDownIntervalMicros();
            // 桶满.
            storedPermits = min(maxPermits, storedPermits + newPermits);
            // 下次时间修改为当前时间
            nextFreeTicketMicros = nowMicros;
        }
    }

}
