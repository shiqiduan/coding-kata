package com.coding;

public class M53 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ret = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ret = Math.max(sum, ret);
        }
        return ret;
    }
}
