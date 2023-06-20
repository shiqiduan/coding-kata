package com.coding.sorting;

/**
 * gap 如何选择？
 * 按 gap 划分组，不同的组进行插入排序
 * <p>
 * 原理：
 * 1. 数量较少的插入排序，效率更高，通过 gap 划分子组
 * 2. 基本有序的数组，插入排序效率高
 */
public class ShellSort {
    public int[] sortArray(int[] nums) {
        shellSort(nums);
        return nums;
    }

    public void shellSort(int[] nums) {

    }
}
