package com.duan;

import java.util.Arrays;
import java.util.concurrent.atomic.*;

public class Test {
    public static void main(String[] args) {
        AtomicBoolean ab = new AtomicBoolean(true);
        System.out.println(ab.get());

        AtomicInteger ai = new AtomicInteger(100);
        System.out.println(ai.compareAndSet(100, 1000));
        System.out.println(ai.get());
        System.out.println(ai.updateAndGet(operand -> operand + 10));

        AtomicIntegerArray aia = new AtomicIntegerArray(new int[]{1, 2, 3});
        System.out.println(aia.get(2));
        System.out.println(aia.compareAndSet(0, 10, 20));

        int[] a = new int[] {};
        int[] b = a.clone();
        System.out.println(a == b);
        System.out.println(Arrays.equals(a, b));

        AtomicLong al = new AtomicLong(100);
        System.out.println(al.addAndGet(10));
    }
}
