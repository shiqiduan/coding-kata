package com.duan.juc;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ReentrantLockDemo {
    ReentrantLock lock = new ReentrantLock();

    public void test() throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread t1 = new Thread(() -> {
                lock.lock();
                try {
                    System.out.println("t" + finalI);
                    Uninterruptibles.sleepUninterruptibly(finalI, SECONDS);
                } finally {
                    lock.unlock();
                }
            });
            list.add(t1);
            t1.start();
        }

        System.out.println(lock.getHoldCount());
        System.out.println(lock.getQueueLength());
        System.out.println(lock.isLocked());

        for (int i = 0; i < 10; i++) {
            list.get(i).join();
        }
    }

    public void testLockInterruptibly() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println("hello");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo demo = new ReentrantLockDemo();
//        demo.test();

        System.out.println("isInterrupted: " + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("isInterrupted: " + Thread.currentThread().isInterrupted());
        try {
            demo.testLockInterruptibly();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
