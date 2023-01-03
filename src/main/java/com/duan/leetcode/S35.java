package com.duan.leetcode;

public class S35 {
    public int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        if(s > nums.length - 1) {
            return s;
        } else if(s < 0) {
            return 0;
        }
        if(nums[s] > target) {
            return s;
        } else {
            return s + 1;
        }
    }
}
