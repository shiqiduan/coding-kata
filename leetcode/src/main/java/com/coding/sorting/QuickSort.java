package com.coding.sorting;

import java.util.Random;

/**
 * 核心思想
 * 1. 选择一个基准数，基于它来划分数组。左边都是小于等于它，右边都是大于等于它
 * 2. 然后，递归在左右两边继续排序
 * <p>
 * 不稳定排序
 */
public class QuickSort {
    private Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int s, int e) {
        if (s >= e) return;
        int p = partition(nums, s, e);
        quickSort(nums, s, p - 1);
        quickSort(nums, p + 1, e);
    }

    private int partition(int[] nums, int s, int e) {
        // 主元选择算法
        int pivot = random.nextInt(e - s + 1) + s;
        swap(nums, pivot, e);

        // 多种实现方式。其他方法：两边找，交换方向。
        // 这里是一趟单向遍历
        int index = s - 1, pv = nums[e];
        for (int i = s; i <= e; i++) {
            if (nums[i] <= pv) {
                swap(nums, i, ++index);
            }
        }
        return index;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
