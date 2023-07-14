package com.coding.two;

public class E70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = b + 2 * a;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        E70 e70 = new E70();
        System.out.println(e70.climbStairs(46));
    }
}
