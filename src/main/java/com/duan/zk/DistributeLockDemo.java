package com.duan.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DistributeLockDemo {
    private final CuratorFramework client;
    private final InterProcessMutex lock;

    public DistributeLockDemo(String lockPath) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        this.client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
        client.start();
        this.lock = new InterProcessMutex(client, lockPath);
    }

    public void doWork() throws Exception {
        if (lock.acquire(2, TimeUnit.SECONDS)) {
            System.out.println("get lock");
            try {
                System.out.println("do work.");
            } finally {
                lock.release();
            }
        } else {
            System.out.println("Not get lock");
        }
    }

    public static void main(String[] args) throws Exception {
        DistributeLockDemo demo = new DistributeLockDemo("/app01/lock");
        demo.doWork();

        final int[] count = {0};

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        demo.lock.acquire();
                        count[0]++;
                        System.out.println(count[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            demo.lock.release();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        service.shutdown();
    }
}
