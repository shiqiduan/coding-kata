package com.coding;

/**
 * 1. 分析题目，选择合适的算法和数据结构
 * 2. 实现代码逻辑，注意边界条件
 * 3. 检查数据，验证边界条件
 */
public class E121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int max = prices[prices.length - 1];
        int ret = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (max > prices[i]) {
                ret = Math.max(ret, max - prices[i]);
            } else {
                max = prices[i];
            }
        }
        return ret;
    }
}
