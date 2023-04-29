package com.sorting;

public class BubbleSort implements Sorting {
    public int[] sort(int[] nums) {
        if (nums.length <= 1) return nums;
        boolean swapped = true;
        int len = nums.length - 1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < len; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swapped = true;
                }
            }
            len--;
        }
        return nums;
    }
}
