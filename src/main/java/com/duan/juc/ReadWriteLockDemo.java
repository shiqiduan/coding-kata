package com.duan.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private int[] array;

    ReadWriteLockDemo(int size) {
        this.array = new int[size];
    }

    public int getByIndex(int i) {
        Lock lock = this.lock.readLock();
        lock.lock();
        try {
            return array[i];
        } finally {
            lock.unlock();
        }
    }

    public void set(int i, int val) {
        Lock lock = this.lock.writeLock();
        lock.lock();
        try {
            array[i] = val;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo(10);
        for (int i = 0; i < 10; i++) {
            demo.set(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(demo.getByIndex(i));
        }
    }
}
