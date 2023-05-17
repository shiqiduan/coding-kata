package com.coding;

import java.util.Arrays;

public class M16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int b = i + 1, c = nums.length - 1;
            while (b < c) {
                int sum = nums[i] + nums[b] + nums[c];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    c--;
                } else {
                    b++;
                }
                int temp = Math.abs(sum - target);
                if (temp < min) {
                    min = temp;
                    ret = sum;
                }
            }
        }
        return ret;
    }
}
