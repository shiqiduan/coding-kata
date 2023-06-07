package com.coding.two;

public class M712 {
    /**
     * 最长公共子串
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        int ans = 0;
        for (int i = 0; i < s1.length(); i++) {
            ans += (int) s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            ans += (int) s2.charAt(i);
        }
        if (s1.length() == 0 | s2.length() == 0) {
            return ans;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + ((int) s1.charAt(i - 1)) * 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return ans - dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println((int) 's');
    }
}
