package com.duan.leetcode;

/**
 * x 的平方根
 */
public class E69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int a = 0, b = x;
        while (true) {
            int mid = a + (b - a) / 2;
            if (mid == a) return a;

            long temp = (long) mid * mid;
            if (temp == x) {
                return mid;
            } else if (temp > x) {
                b = mid;
            } else {
                a = mid;
            }
        }
    }

    public static void main(String[] args) {
        E69 e = new E69();

        System.out.println(e.mySqrt(0));
        System.out.println(e.mySqrt(1));
        System.out.println(e.mySqrt(9));
        System.out.println(e.mySqrt(10));
        System.out.println(e.mySqrt(8));
        System.out.println(e.mySqrt(2147395599));
    }
}
