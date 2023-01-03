package com.duan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M78 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> currentList = new ArrayList<>();
            track(nums, i, currentList, ret);
        }
        return ret;
    }

    private void track(int[] nums, int index, List<Integer> currentList, List<List<Integer>> ret) {
        if(index > nums.length) return;

        currentList.add(nums[index]);
        ret.add(currentList);

        for (int i = index + 1; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(currentList);
            track(nums, i, temp, ret);
        }
    }
}