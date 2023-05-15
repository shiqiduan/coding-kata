package com.coding;

public class E1137 {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            int temp = a;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}