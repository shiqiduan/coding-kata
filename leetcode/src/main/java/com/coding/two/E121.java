package com.coding.two;

/**
 * 1. 分析题目，选择合适的算法和数据结构
 * 2. 实现代码逻辑，注意边界条件
 * 3. 检查数据，验证边界条件
 * <p>
 * 太粗了
 */
public class E121 {
    public int maxProfit(int[] prices) {
        int cost = prices[0], profile = 0;
        for (int i = 1; i < prices.length; i++) {
            cost = Math.min(prices[i], cost);
            profile = Math.max(prices[i] - cost, profile);
        }
        return profile;
    }
}
