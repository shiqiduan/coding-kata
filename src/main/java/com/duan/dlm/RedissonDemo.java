package com.duan.dlm;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

public class RedissonDemo {
    private Config config;
    // Sync and Async API
    private RedissonClient redisson;
    private RedissonReactiveClient redissonReactive;
    private RedissonRxClient redissonRx;

    public RedissonDemo() {
        redisson = Redisson.create();
//        redissonReactive = redisson.reactive();
//        redissonRx = redisson.rxJava();
    }

    public void testRedisAPI() {
        RMap<String, Integer> map =  redisson.getMap("myMap");
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        boolean contains = map.containsKey("a");

        redisson.shutdown();
        System.out.println("end");
    }

    public void testLock() throws InterruptedException {
        RLock lock = redisson.getLock("lock");
        lock.lock();

        Thread t = new Thread() {
            public void run() {
                RLock lock1 = redisson.getLock("lock");
                lock1.lock();
                System.out.println("t 1");
                lock1.unlock();
            };
        };

        t.start();
        System.out.println("t 0");
        Thread.sleep(10 * 1000);
        System.out.println("t 0");
        lock.unlock();
        t.join();
        redisson.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        RedissonDemo demo = new RedissonDemo();
        demo.testLock();
    }
}
