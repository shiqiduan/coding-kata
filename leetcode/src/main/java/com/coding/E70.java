package com.coding;

public class E70 {
    // f(n) = f(n - 1) + f(n - 2)
    // f(0) = 0
    // f(1) = 1
    // f(2) = 2
    // f(3) = 3
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int a = 1, b = 1, c = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        E70 e70 = new E70();
        System.out.println(e70.climbStairs(46));
    }
}
