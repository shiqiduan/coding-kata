package com.coding;

public class M494 {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }

    private int dfs(int[] nums, int target, int index) {
        if (index == nums.length && target == 0) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }
        return dfs(nums, target - nums[index], index + 1)
                + dfs(nums, target + nums[index], index + 1);
    }

    public static void main(String[] args) {
        M494 m = new M494();

        System.out.println(m.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(m.findTargetSumWays(new int[]{1}, 1));
    }
}
