package com.coding;

public class M80 {
    public int removeDuplicates(int[] nums) {
        int current = 1, last = 1;

        int count = 1;
        while (last < nums.length) {
            if (nums[last] != nums[current - 1]) {
                count = 1;
                nums[current] = nums[last];
                current++;
            } else {
                count++;
                if (count < 3) {
                    nums[current] = nums[last];
                    current++;
                }
            }
            last++;
        }
        return current;
    }
}
