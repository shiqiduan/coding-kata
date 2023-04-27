package com.coding;

public class E35 {
    public int searchInsert(int[] nums, int target) {
        int a = 0, b = nums.length - 1;

        while (a <= b) {
            int mid = a + (b - a) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                a = mid + 1;
            } else {
                b = mid - 1;
            }
        }
        return a + 1;
    }
}
