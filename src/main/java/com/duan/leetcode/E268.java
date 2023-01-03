package com.duan.leetcode;

public class E268 {
    public int missingNumber(int[] nums) {
        int index = 0;
        int last = -1;
        while (index < nums.length) {
            if (nums[index] == index) {
                index++;
                continue;
            }
            if (nums[index] == nums.length) {
                last = index;
                index++;
                continue;
            }
            swap(nums, nums[index], index);
        }
        return (last >= 0) ? last : nums.length;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        E268 e = new E268();

        System.out.println(e.missingNumber(new int[] {0, 1}));
        System.out.println(e.missingNumber(new int[] {0}));
        System.out.println(e.missingNumber(new int[] {1}));
        System.out.println(e.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
    }
}
