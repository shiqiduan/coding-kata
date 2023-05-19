package com.coding;

public class M209 {
    public int minSubArrayLen(int target, int[] nums) {
        int s = 0, e = 0, sum = nums[0];
        int minLen = Integer.MAX_VALUE;
        while (s < nums.length || e < nums.length) {
            if (sum < target) {
                if (e < nums.length - 1) {
                    e++;
                    sum += nums[e];
                    continue;
                }
                break;
            } else {
                minLen = Math.min(minLen, e - s + 1);
                sum -= nums[s];
                s++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
