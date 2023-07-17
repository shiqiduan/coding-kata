package com.coding.three;

/**
 * 与 322 的区别是什么？ 求组合数量， 322 求的是最小硬币数量
 * 1. 初始值不一样
 * 2. 遍历顺序不一样 —— 关键
 * 3. 子结构不一样
 * <p>
 * 参数的限制，导致回溯的复杂度超时
 * 组合 vs 排列
 * <p>
 * 重复的如何去重呢？
 */
public class M518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    /**
     * 322
     */
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        dp[0] = 0;
        // 逐个金额计算
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int c = coins[j];
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i]);

                    System.out.println(i + " " + coins[j] + " " + dp[j]);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : (int) dp[amount];
    }

    public static void main(String[] args) {
        M518 m = new M518();

        System.out.println(m.change(5, new int[]{1, 2, 5}));
        System.out.println("##########");
        System.out.println(m.coinChange(new int[]{1, 2, 5}, 5));
    }
}
