package com.coding.three;

import java.util.Arrays;
import java.util.Collections;

/**
 * 特征: 最小的硬币数量
 * <p>
 * 回溯的复杂度：n^n次方 ？
 * <p>
 * 背包的动态规划 - ？。 完全背包问题，物品可以无限使用，必须装满。
 * 1. dp[i] 表示最小的数量
 * 2. dp[i] = Min(dp[i - coin] + 1, dp[i])
 * <p>
 * 深度遍历
 * <p>
 * 广度遍历
 */
public class M322 {
    /**
     * 动态规划
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int c = coins[j];
                if ((i - c) >= 0) {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 递归 - 是一种编程结构。
     * 回溯 - 一种最优化的编程算法。
     * <p>
     * 时间复杂度：amount ^ coins数量 次方
     */
    private int ans = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        Collections.reverse(Arrays.asList(coins));
        track(coins, amount, 0);
        return (Integer.MAX_VALUE == ans) ? -1 : ans;
    }

    private void track(int[] coins, int amount, int count) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        if (amount < 0) {
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            track(coins, amount - coins[i], count + 1);
        }
    }
}
