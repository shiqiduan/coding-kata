package com.coding;

public class E905 {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r && l < nums.length && r >= 0) {
            while (l < nums.length && nums[l] % 2 == 0) {
                l++;
            }
            while (r >= 0 && nums[r] % 2 != 0) {
                r--;
            }
            if (l >= r) {
                return nums;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
}
