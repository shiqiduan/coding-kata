package com.coding.sorting;

/**
 * 稳定排序
 * <p>
 * 核心思想是比较
 */
public class BubbleSort {
    public int[] sortArray(int[] nums) {
        bubbleSort(nums);
        return nums;
    }

    public void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化版本。检查是否发生交换
     */
    public void bubbleSort1(int[] nums) {
        boolean swap = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                return;
            }
        }
    }
}
