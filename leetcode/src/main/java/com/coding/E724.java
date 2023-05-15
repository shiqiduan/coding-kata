package com.coding;

public class E724 {
    public int pivotIndex(int[] nums) {
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == (right - nums[i])) {
                return i;
            }
            left += nums[i];
            right -= nums[i];
        }
        return -1;
    }
}
