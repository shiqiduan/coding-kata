package com.coding;

public class M647 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)
                        && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
