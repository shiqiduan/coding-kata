package com.sorting;

public class MergeSort implements Sorting {
    @Override
    public int[] sort(int[] nums) {
        int[] result = new int[nums.length];
        sort(nums, result, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int[] result, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;

        sort(nums, result, start, mid);
        sort(nums, result, mid + 1, end);

        int k = start;
        int a = start, b = mid, c = mid + 1, d = end;
        while (a <= b && c <= d) {
            result[k++] = nums[a] <= nums[c] ? nums[a++] : nums[c++];
        }
        while (a <= b) {
            result[k++] = nums[a++];
        }
        while (c <= d) {
            result[k++] = nums[c++];
        }
        for (k = start; k <= end; k++) {
            nums[k] = result[k];
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
