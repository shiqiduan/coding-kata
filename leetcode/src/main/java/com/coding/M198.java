package com.coding;

public class M198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 3];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = i + 3;
            dp[x] = Math.max(dp[x - 2], dp[x - 3]) + nums[i];
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        M198 m = new M198();
        System.out.println(m.rob(new int[]{1, 2, 3, 1}));
        System.out.println(m.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(m.rob(new int[]{2}));
        System.out.println(m.rob(new int[]{7, 2}));
    }
}
