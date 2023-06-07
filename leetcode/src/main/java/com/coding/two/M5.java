package com.coding.two;

public class M5 {
    public String longestPalindrome(String s) {
        return "";
    }

    /**
     * 暴力求解 n * n * n
     */
    public String longestPalindrome1(String s) {
        return "";
    }

    /**
     * 插入桩求解  n * n
     */
    public String longestPalindrome2(String s) {
        return "";
    }

    /**
     * 动态规划求解
     * dp[x][y] = (x = y) && dp[x + 1][y - 1]
     */
    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i + L - 1;
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
