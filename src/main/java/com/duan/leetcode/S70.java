package com.duan.leetcode;

public class S70 {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int a = 1, b = 1, c = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        S70 s = new S70();
        System.out.println(s.climbStairs(2));
        System.out.println(s.climbStairs(3));
        System.out.println(s.climbStairs(4));
    }
}
