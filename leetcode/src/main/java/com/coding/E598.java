package com.coding;

public class E598 {
    public int maxCount(int m, int n, int[][] ops) {
        int a = m, b = n;
        for (int i = 0; i < ops.length; i++) {
            a = Math.min(a, ops[i][0]);
            b = Math.min(b, ops[i][1]);
        }
        return a * b;
    }
}
