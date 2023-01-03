package com.duan.leetcode;

public class S1137 {
    public int tribonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n <= 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int ret = a + b + c;
            a = b;
            b = c;
            c = ret;
        }
        return c;
    }

    public static void main(String[] args) {
        S1137 s = new S1137();
        System.out.println(s.tribonacci(3));
        System.out.println(s.tribonacci(4));
    }
}
