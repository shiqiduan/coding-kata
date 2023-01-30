package com.coding;

import java.util.Arrays;

public class E414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        if (nums.length < 3) {
            return nums[nums.length - 1];
        }

        int count = 1;
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != temp) {
                count++;
                temp = nums[i];
            }
            if (count == 3) {
                return temp;
            }
        }
        return nums[nums.length - 1];
    }
}
