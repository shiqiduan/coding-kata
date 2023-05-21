package com.coding;

public class E303 {
}

class NumArray {

    private final int[] array;

    public NumArray(int[] nums) {
        array = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            array[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return array[right];
        return array[right] - array[left - 1];
    }
}