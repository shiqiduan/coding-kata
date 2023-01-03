package com.duan.leetcode;

public class S80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int insertIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            int gap = i - insertIndex;
            if(nums[i] == nums[i - 1 - gap] && nums[i] == nums[i - 2 - gap]) {
                continue;
            }
            if(insertIndex != i) {
                nums[insertIndex] = nums[i];
            }
            insertIndex++;
        }
        return insertIndex;
    }
}
