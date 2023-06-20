package com.coding.sorting;

public class MergeSort {
    private int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 从上往下
     */
    private void mergeSort(int[] nums, int s, int e) {
        if (s >= e) return;

        int mid = s + (e - s) / 2;
        mergeSort(nums, s, mid);
        mergeSort(nums, mid + 1, e);

        int i = s, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= e) {
            if (nums[i] <= nums[j]) {
                temp[cnt++] = nums[i++];
            } else {
                temp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[cnt++] = nums[i++];
        }
        while (j <= e) {
            temp[cnt++] = nums[j++];
        }
        for (int k = 0; k < e - s + 1; k++) {
            nums[s + k] = temp[k];
        }
    }
}
