package com.duan.leetcode;

import java.util.Arrays;

public class S322 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        S322 s = new S322();

        System.out.println(s.coinChange(new int[]{186,419,83,408}, 6249));
        System.out.println(s.coinChange(new int[]{1,2,5}, 11));
        System.out.println(s.coinChange(new int[]{2}, 3));
        System.out.println(s.coinChange(new int[]{1}, 0));
    }
}
