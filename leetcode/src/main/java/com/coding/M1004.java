package com.coding;

public class M1004 {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int start = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if (c == 0) {
                if (zeroCount < k) {
                    zeroCount++;
                } else if (zeroCount == k) {
                    while (nums[start] != 0) {
                        start++;
                    }
                    start++;
                }
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
