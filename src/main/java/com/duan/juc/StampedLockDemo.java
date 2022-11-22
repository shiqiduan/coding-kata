package com.duan.juc;

import java.util.concurrent.locks.StampedLock;

/**
 * 提供了快照读？一方面是为了优化性能，无锁提高了性能。
 * 通过 stamp，同时保障了一致性。
 *
 * 严格来讲，并没有快照，只有一个乐观锁的版本号
 *
 * 不支持重入 ？ why
 *
 * 特殊场景：当线程阻塞在读写锁上时，如果被中断，则 CPU 会飙升？ why
 * 内部实现里while循环里面对中断的处理有点问题
 *
 */

public class StampedLockDemo {
}

class Point {
    private int x, y;
    final StampedLock sl = new StampedLock();

    public double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();
        // 读局部变量
        int curX = x, curY = y;

        if(!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(curX * curX + curY * curY);
    }
}