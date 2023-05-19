package com.coding;

public class M75 {
    public void sortColors(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s <= e && nums[s] == 0) {
            s++;
        }
        while (e >= s && nums[e] == 2) {
            e--;
        }
        for (int i = s; i <= e; i++) {
            if (nums[i] == 2) {
                swap(nums, i, e--);
                i--;
                continue;
            }
            if (nums[i] == 0) {
                swap(nums, i, s++);
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
