package com.sorting;

public class SelectionSort implements Sorting {
    @Override
    public int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }
}
