package com.coding;

public class M931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    up = Math.min(up, dp[i - 1][j - 1]);
                }
                up = Math.min(up, dp[i - 1][j]);
                if (j + 1 < n) {
                    up = Math.min(up, dp[i - 1][j + 1]);
                }
                dp[i][j] = matrix[i][j] + up;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m - 1][i]);
        }
        return ans;
    }
}
