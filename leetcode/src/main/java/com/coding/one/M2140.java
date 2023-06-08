package com.coding.one;

/**
 * dp[i] 当前问题及之后的问题的最大分数
 */
public class M2140 {

    /**
     * dp[i] 当前问题及之后的问题的最大分数 [i, n - 1]
     *
     * @param questions
     * @return
     */
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = i + questions[i][1] + 1;
            dp[i] = Math.max(dp[i + 1], questions[i][0] + ((x >= n) ? 0 : dp[x]));
        }
        return dp[0];
    }

    /**
     * dp[i] = [0, i];
     */
    public long mostPoints1(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            int x = Math.min(n, i + questions[i][1] + 1);
            dp[x] = Math.max(dp[x], dp[i] + questions[i][0]);
        }
        return dp[n];
    }
}
