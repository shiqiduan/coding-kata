package com.duan.leetcode;

public class S31 {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i < 0) {
            reverse(nums, 0, nums.length-1);
        } else {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i+1, nums.length - 1);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while ((end - start) >= 1) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
