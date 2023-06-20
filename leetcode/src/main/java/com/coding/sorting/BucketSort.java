package com.coding.sorting;

/**
 * 典型例子：26 个英文字母进行排序
 * <p>
 * 稳定
 * <p>
 * 核心思想：分桶
 */
public class BucketSort {

    public void bucketSort(int[] nums) {
        // 找到最大值，用来设置桶的数量
        // 26 个英文字符，就需要 26 长度的数组
        // 其他场景，需要综合平衡空间和时间，是否可以放入内存等
        int max = 0;
        // 创建桶
        int[] buckets = new int[max];
        // 依次遍历数组元素，在桶的位置上+1 操作。
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i]]++;
        }
        // 依次遍历，返回结果
    }
}
