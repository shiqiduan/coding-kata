package com.coding;

public class E1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0, t = 0;
        for (int i = 0; i < accounts.length; i++) {
            int m = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                m += accounts[i][j];
            }
            if (m > max) {
                max = m;
                t = 1;
            } else if (m == max) {
                t++;
            }
        }
        return max;
    }
}
