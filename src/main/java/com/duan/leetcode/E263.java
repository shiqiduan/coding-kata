package com.duan.leetcode;

public class E263 {
    int[] yins = new int[]{2, 3, 5};

    public boolean isUgly(int n) {
        if(n <= 0) return false;
        if (n == 1) return true;

        for (int i = 0; i < yins.length; i++) {
            while (n % yins[i] == 0) {
                n = n / yins[i];
                if(n == 1) return true;
            }
        }
        return false;
    }
}
