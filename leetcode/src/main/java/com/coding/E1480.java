package com.coding;

public class E1480 {
    public int[] runningSum(int[] nums) {
        int[] ret = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ret[i] = sum;
        }
        return ret;
    }
}
