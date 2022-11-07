package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class M139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if(dp[i] == 1 && wordDict.contains(s.substring(i, j))) {
                    dp[j] = 1;
                }
            }
        }
        return dp[s.length()] == 1;
    }

    public static void main(String[] args) {
        M139 m = new M139();

        System.out.println(test("catsandog", new String[] {"cats", "dog", "sand", "and", "cat"}, m));
    }

    private static boolean test(String s, String[] list, M139 m) {
        List<String> l = new ArrayList<>();
        for (String a : list) {
            l.add(a);
        }
        return m.wordBreak(s, l);
    }

}
