package com.coding.two;

public class M516 {
    /**
     * 1. 确定 dp 数组的含义
     * 2. 一定比较字符串相等，s.charAt(i) == s.charAt(j)
     * 如果相等： dp[i][j] = dp[i + 1][j - 1] + 2
     * 如果不相等：dp[i][j] = Max(d[[i][j - 1], d[i + 1][j])
     * 3. 初始状态：i = j = 1，其他为 0
     * 4. 遍历顺序：矩阵的遍历顺序，从下到上，从左到右
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
