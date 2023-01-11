package com.duan.leetcode;

import java.util.Arrays;

public class E628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int rightMax = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], rightMax);
    }
}
