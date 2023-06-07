package com.coding.two;

public class M673 {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        int ans = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                ans = cnt[i];
            } else if (dp[i] == max) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        M673 m = new M673();
        System.out.println(m.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }
}
