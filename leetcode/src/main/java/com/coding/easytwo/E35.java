package com.coding.easytwo;

/**
 * 二分查找
 * 1. 循环不变量
 * 细节
 * 1. 条件、mid 计算
 * 2. 返回值
 */
public class E35 {
    public int searchInsert(int[] nums, int target) {
        // 区间，左闭右闭合
        int s = 0, e = nums.length - 1;
        // 相等时区间依然有效
        while (s <= e) {
            // 不变
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
