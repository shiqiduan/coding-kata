package com.coding.two;

public class M740 {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] sum = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }
        return rob(sum);
    }

    private int rob(int[] sum) {
        int a = sum[0], b = Math.max(sum[0], sum[1]);
        for (int i = 2; i < sum.length; i++) {
            int c = Math.max(a + sum[i], b);
            a = b;
            b = c;
        }
        return b;
    }
}
