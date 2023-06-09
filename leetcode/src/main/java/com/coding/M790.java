package com.coding;

public class M790 {
    int mod = (int) (1e9 + 7);

    public int numTilings(int n) {
        int[][] dp = new int[n + 1][4];
        dp[1][0] = dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            int x = 0;
            for (int j = 0; j < 4; j++) {
                x += dp[i - 1][j];
                x %= mod;
            }
            dp[i][1] = x;
            dp[i][2] = (dp[i - 1][3] + dp[i - 1][0]) % mod;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][0]) % mod;
        }
        return dp[n][1];
    }
}
