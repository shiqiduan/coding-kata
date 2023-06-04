package com.coding;

public class M713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int s = 0, e = 0, ans = 0, mul = 1;
        while (e < nums.length) {
            mul *= nums[e];

            while (mul >= k) {
                mul /= nums[s];
                s++;
            }

            ans += e - s + 1;
            e++;
        }
        return ans;
    }
}
