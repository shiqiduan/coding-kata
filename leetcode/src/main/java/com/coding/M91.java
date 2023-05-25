package com.coding;

public class M91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            int a = Character.getNumericValue(s.charAt(i));
            int b = Character.getNumericValue(s.charAt(i - 1)) * 10 + a;

            if (a != 0) {
                dp[i + 1] = dp[i];
            }
            if (b >= 10 && b <= 26) {
                dp[i + 1] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
