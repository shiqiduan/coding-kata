package com.coding;

public class M55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
