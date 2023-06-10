package com.coding.one;

public class E977 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                a = i;
            }
        }
        b = a + 1;

        while (a >= 0 || b < nums.length) {
            if (a >= 0 && b < nums.length) {
                if (Math.abs(nums[a]) <= Math.abs(nums[b])) {
                    ans[c] = nums[a] * nums[a];
                    a--;
                } else {
                    ans[c] = nums[b] * nums[b];
                    b++;
                }
            } else if (a >= 0) {
                ans[c] = nums[a] * nums[a];
                a--;
            } else {
                ans[c] = nums[b] * nums[b];
                b++;
            }
            c++;
        }
        return ans;
    }
}
