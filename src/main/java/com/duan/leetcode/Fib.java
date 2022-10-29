package com.duan.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author shiqiduan
 */
public class Fib {
    public long fib(int n) {
        if (n <= 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public long fib1(int n) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        map.put(1, 1L);
        return fib1_1(n, map);
    }

    private long fib1_1(int n, Map<Integer, Long> map) {
        if (map.containsKey(n)) return map.get(n);
        long value = fib1_1(n - 1, map) + fib1_1(n - 2, map);
        map.put(n, value);
        return value;
    }

    public long fib2(int n) {
        if (n <= 1) return 1;
        long prev = 1L, current = 1L;
        for (int i = 0; i < (n - 1); i++) {
            long newValue = prev + current;
            prev = current;
            current = newValue;
        }
        return current;
    }

    public static void main(String[] args) {
        Fib f = new Fib();
        System.out.println(f.fib(45));

        System.out.println(f.fib1(45));
        System.out.println(f.fib2(45));
    }
}
