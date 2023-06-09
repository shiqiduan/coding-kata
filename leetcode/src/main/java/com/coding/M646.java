package com.coding;

import java.util.Arrays;
import java.util.Comparator;

public class M646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[pairs.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= pairs.length; i++) {
            int[] c = pairs[i - 1];
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                int[] p = pairs[j - 1];
                if (c[0] > p[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[pairs.length];
    }

    /**
     * 贪心
     */
    public int findLongestChain1(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int ans = 1;
        int[] p = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            int[] c = pairs[i];
            if (c[0] > p[1]) {
                ans++;
                p = c;
            }
        }
        return ans;
    }
}
