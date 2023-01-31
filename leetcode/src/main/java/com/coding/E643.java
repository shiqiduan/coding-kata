package com.coding;

public class E643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double ret = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        ret = sum * 1.0 / k;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            ret = Math.max(ret, sum * 1.0 / k);
        }
        return ret;
    }
}
