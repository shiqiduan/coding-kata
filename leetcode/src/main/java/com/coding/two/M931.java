package com.coding.two;

public class M931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j];
                if ((j - 1) >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
                }
                dp[i][j] += matrix[i][j];
            }
        }
        int min = dp[m - 1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }

    public int minFallingPathSum1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i - 1][j];
                if ((j - 1) >= 0) {
                    temp = Math.min(temp, matrix[i - 1][j - 1]);
                }
                if (j + 1 < n) {
                    temp = Math.min(temp, matrix[i - 1][j + 1]);
                }
                matrix[i][j] = temp + matrix[i][j];
            }
        }
        int min = matrix[m - 1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, matrix[m - 1][i]);
        }
        return min;
    }

    public int minFallingPathSum2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n + 1];
        dp[dp.length - 1] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            int last = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int temp = dp[j];
                dp[j] = Math.min(Math.min(dp[j], last), dp[j + 1]) + matrix[i][j];
                last = temp;
            }
        }
        int min = dp[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
