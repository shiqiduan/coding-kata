package com.duan.leetcode;

/**
 * 背包问题
 * 1. 动态规划，二维数组
 * 2. 01 背包问题？
 *
 * 复杂度分析：时间、空间
 */
public class M416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (Integer x : nums) {
            sum += x;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        dp[0][0] = true; // 优化代码

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];

                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }

    /**
     * 01 背包，一维数组，从右向左
     *
     * @param nums
     * @return
     */
    public boolean canPartition01(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (Integer x : nums) {
            sum += x;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        dp[0] = true; // 优化代码

        for (int i = 1; i < len; i++) {
            for (int j = target; j >= 0 && nums[i] <= j; j--) { // 从右向左
                dp[j] = dp[j] || dp[j - nums[i]];
            }
            if (dp[target]) {
                return true;
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        M416 m = new M416();
        System.out.println(m.canPartition01(new int[]{1, 2, 5}));
    }
}
