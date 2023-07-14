package com.coding.one;

public class M50 {
    /**
     * 快速幂运算
     */
    public double myPow(double x, int n) {
        long N = n;
        return (N >= 0) ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) return 1.0;
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y + 1;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(-3, 0));
    }
}
