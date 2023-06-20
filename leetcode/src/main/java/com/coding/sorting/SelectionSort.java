package com.coding.sorting;

/**
 * 比冒泡少了很多的交换操作
 * <p>
 * 不稳定
 */
public class SelectionSort {
    public int[] sortArray(int[] nums) {
        selectionSort(nums);
        return nums;
    }

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
