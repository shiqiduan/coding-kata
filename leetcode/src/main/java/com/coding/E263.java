package com.coding;

public class E263 {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        for (int x : new int[]{2, 3, 5}) {
            while (n % x == 0) {
                n = n / x;
            }
        }
        return n == 1;
    }
}
