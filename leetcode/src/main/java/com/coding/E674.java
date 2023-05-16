package com.coding;

public class E674 {
    public int findLengthOfLCIS(int[] nums) {
        int l = 0, max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                max = Math.max(max, i - l + 1);
            } else {
                l = i;
            }
        }
        return max;
    }
}
