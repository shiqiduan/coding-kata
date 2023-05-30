package com.coding;

public class M309 {
    public int maxProfit(int[] prices) {
        // dp[i][0] = 当天没有持股，且昨天也没有持股
        // dp[i][1] = 当前持股
        // dp[i][2] = 当天没有持股，因为刚刚卖出
        int[][] dp = new int[prices.length][3];
        // 初始状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        // 状态转移方程
        // dp[i][0] = max(昨天没有持股的收益)
        // dp[i][1] = max(今天刚买的，昨天没有持股且昨天的昨天也没持股) - 支出
        // dp[i][2] = 昨天持股 + 今天收入
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i][1] + prices[i];
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
