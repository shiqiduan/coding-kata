package com.duan.leetcode;

public class S215 {

    private int randomPivot(int[] nums, int start, int end) {
        return (int) (start + Math.random() * (end - start));
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = randomPivot(nums, start, end);
        int left = start;
        int right = end;
        while (true) {
            while (nums[left] < pivot) {
                left++;
            }
            while (nums[right] > pivot) {
                right--;
            }
            if(left >= right) {
                swap(nums, left, pivot);
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
