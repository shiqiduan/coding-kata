package com.duan.leetcode;

public class s287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {
                if(nums[nums[i] - 1] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        return 0;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
