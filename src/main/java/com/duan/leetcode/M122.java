package com.duan.leetcode;

/**
 * 当天买的话，计算下次盈利日期.
 */
public class M122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int a = prices[i] - prices[i - 1];
            if(a >= 0) {
                sum += a;
            }
        }
        return sum;
    }
}
