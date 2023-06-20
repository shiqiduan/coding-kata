package com.coding.sorting;

/**
 * 算法思想：有序部分 和 无序部分
 */
public class InsertSort {
    public int[] sortArray(int[] nums) {
        insertSort(nums);
        return nums;
    }

    public void insertSort(int[] nums) {
        int j, k;
        // 从第二个元素开始
        for (int i = 1; i < nums.length; i++) {
            // 依次在有序列表中比较，找到插入位置。
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    break;
                }
            }

            if (j != i - 1) {
                int temp = nums[i];
                for (k = i - 1; k > j; k--) {
                    nums[k + 1] = nums[k];
                }
                nums[k + 1] = temp;
            }
        }
    }
}
