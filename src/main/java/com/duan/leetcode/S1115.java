package com.duan.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class S1115 {
}

class FooBar {
    private int n;
    private int evenLimit;
    private int oddLimit;

    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
        s1.release();
        if(n % 2 == 0) {
            evenLimit = n;
            oddLimit = n-1;
        } else {
            oddLimit = n;
            evenLimit = n - 1;
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s1.release();
        }
    }
}

class ZeroEvenOdd {
    private int n;

    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);
    private Semaphore s3 = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
        s1.release();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            s1.acquire();
            printNumber.accept(0);
            if(i % 2 == 0) s2.release();
            else s3.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            s2.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            s3.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }
}