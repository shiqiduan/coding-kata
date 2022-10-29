package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(i != (nums[i] - 1)) {
                ret.add(nums[i]);
            }
        }
        return ret;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
