package com.duan.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 延伸一个问题：为什么不支持锁升级，为什么要支持锁降级呢？
 *
 * 这是一种设计权衡
 *
 * 如果支持读锁升级，可能导致死锁。线程 A 获取了读锁，要去抢占写锁。线程 B 也获取了读锁,要去抢占写锁. 此时，他们都希望对方
 * 放弃读锁。死锁了。
 * 那么，锁降级是优化了什么呢？ 数据的可见性，有可能当前线程自己加载的数据被覆盖，谁有读不到
 *
 * @param <K>
 * @param <V>
 */
public class Cache<K, V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    V get(K k) {
        V v = null;
        r.lock();
        try {
            v = m.get(k);
        } finally {
            r.unlock();
        }
        if(v != null) {
            return v;
        }
        // 可能被其他线程插入
        w.lock();
        try {
            v = m.get(k);
            if(v != null) {
                return v;
            }
            // 加载数据
            // 设置缓存
        } finally {
            w.unlock();
        }
        return v;
    }
}
