package com.coding;

public class M31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j >= i + 1; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int a, int b) {
        while (a < b) {
            swap(nums, a, b);
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        M31 m = new M31();
        // m.nextPermutation(new int[]{2, 2, 0, 4, 3, 1});
        m.nextPermutation(new int[]{2, 3, 1});
    }
}
