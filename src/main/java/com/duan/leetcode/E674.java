package com.duan.leetcode;

public class E674 {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1, start = 0, i = 1;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                max = Math.max(max, i - start);
                start = i;
            }
        }
        max = Math.max(max, i - start);
        return max;
    }
}
