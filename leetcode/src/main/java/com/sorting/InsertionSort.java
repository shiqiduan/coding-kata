package com.sorting;

public class InsertionSort implements Sorting {
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;
        }
        return nums;
    }
}
