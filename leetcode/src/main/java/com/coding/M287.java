package com.coding;

public class M287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int index = nums[i] - 1;

            if (nums[index] == 0) {
                return nums[i];
            } else {
                nums[i] = nums[index];
                nums[index] = 0;
                i--;
            }
        }
        return 0;
    }
}
