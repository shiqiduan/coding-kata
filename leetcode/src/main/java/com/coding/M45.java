package com.coding;

import java.util.Arrays;

public class M45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int t = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= t; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
