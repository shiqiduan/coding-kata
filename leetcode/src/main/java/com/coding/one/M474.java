package com.coding.one;

import java.util.HashMap;
import java.util.Map;

public class M474 {
    public int findMaxForm(String[] strs, int m, int n) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int l1 = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    l1++;
                }
            }
            map.put(i, new int[]{s.length() - l1, l1});
        }

        int[][] dp = new int[m + 1][n + 1];

        // 遍历顺序
        for (int i = 1; i <= strs.length; i++) {
            int[] x = map.get(i - 1);
            int zero = x[0], one = x[1];
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
