package com.coding;

import java.util.Arrays;

public class E561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            ret += nums[i];
        }
        return ret;
    }
}
