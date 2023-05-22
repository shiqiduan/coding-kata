package com.coding;

public class M213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(range(nums, 0, nums.length - 2),
                range(nums, 1, nums.length - 1));
    }

    private int range(int[] nums, int start, int end) {
        int f = nums[start], s = Math.max(f, nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = s;
            s = Math.max(f + nums[i], s);
            f = temp;
        }
        return s;
    }
}
