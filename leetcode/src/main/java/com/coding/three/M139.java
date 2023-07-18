package com.coding.three;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i] && set.contains(s.substring(i, j + 1))) {
                    dp[j + 1] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
