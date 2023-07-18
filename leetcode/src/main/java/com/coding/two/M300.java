package com.coding.two;

import java.util.Arrays;

public class M300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int x : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = i + (j - i) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (res == j) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        M300 m = new M300();

        System.out.println(m.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18, 1, 2, 3, 4, 5}));
        System.out.println(m.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
