package com.duan.leetcode;

public class S26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
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
