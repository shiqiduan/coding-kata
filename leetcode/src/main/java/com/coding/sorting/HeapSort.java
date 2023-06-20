package com.coding.sorting;

/**
 * @see com.coding.two.heap.MinIntHeap
 */
public class HeapSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length - 1;
        int beginIndex = (nums.length >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(nums, i, len);
        }
        for (int i = len; i > 0; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i - 1);
        }
        return nums;
    }

    // heapDown
    private void maxHeapify(int[] nums, int index, int len) {
        int li = (index << 1) + 1; // 左子树索引
        int ri = li + 1; // 右子树索引
        int cMax = li;
        if (li > len) return; // 超过范围
        if (ri <= len && nums[ri] > nums[li]) {
            cMax = ri;
        }
        if (nums[cMax] > nums[index]) {
            swap(nums, cMax, index);
            maxHeapify(nums, cMax, len);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
