package com.coding;

public class E1470 {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < 0) {
                continue;
            }
            int c = i, cv = nums[c];
            int t = (c < n) ? c * 2 : (c - n) * 2 + 1;
            while (nums[t] > 0) {
                int temp = nums[t];
                nums[t] = -cv;
                c = t;
                cv = temp;
                t = (c < n) ? c * 2 : (c - n) * 2 + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }
        return nums;
    }
}
