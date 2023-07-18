package com.coding.three;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i + 1))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
