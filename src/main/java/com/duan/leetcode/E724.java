package com.duan.leetcode;

public class E724 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;

        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
