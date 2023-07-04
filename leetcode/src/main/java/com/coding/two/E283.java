package com.coding.two;

public class E283 {
    public void moveZeroes(int[] nums) {
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                last++;
                if (last != i) {
                    nums[last] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}
