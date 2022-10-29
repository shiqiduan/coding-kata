package com.duan.leetcode;

import java.util.Random;

public class S215new {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        return nums[quicksort(nums, 0, nums.length - 1, nums.length - k)];
    }

    private int quicksort(int[] nums, int l, int r, int index) {
        int partition = partition(nums, l, r);
        if(partition == index) {
            return partition;
        }
        if(partition > index) {
            return quicksort(nums, l, partition - 1, index);
        } else {
            return quicksort(nums, partition + 1, r, index);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = randomPivot(l, r);
        swap(nums, pivot, r);
        int start = l;
        int pivotValue = nums[r];
        for (int i = l; i < r; i++) {
            if(nums[i] < pivotValue) {
                swap(nums, start, i);
                start++;
            }
        }
        swap(nums, start, r);
        return start;
    }

    private int randomPivot(int l, int r) {
        return random.nextInt(r - l + 1) + l;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        S215new s = new S215new();
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(s.findKthLargest(new int[]{3}, 1));
        System.out.println(s.findKthLargest(new int[]{3, 2}, 2));
        System.out.println(s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
