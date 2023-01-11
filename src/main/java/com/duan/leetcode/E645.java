package com.duan.leetcode;

import java.util.List;

public class E645 {
    public int[] findErrorNums(int[] nums) {
        int index = -1;
        int i = 0;
        int[] ret = new int[2];
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i] - 1]) {
                ret[0] = nums[i];
                index = i;
                i++;
                continue;
            }
            swap(nums, i, nums[i] - 1);
        }
        ret[1] = index + 1;
        return ret;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        E645 e = new E645();

        System.out.println(e.findErrorNums(new int[] {3,2,2}));
    }
}
