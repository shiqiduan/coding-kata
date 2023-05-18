package com.coding;

public class M122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int start = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                max += prices[i - 1] - prices[start];
                start = i;
            }
        }
        max += prices[prices.length - 1] - prices[start];
        return max;
    }
}
