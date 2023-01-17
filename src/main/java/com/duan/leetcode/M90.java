package com.duan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        int last = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if(last == nums[i]) {
                continue;
            }
            last = nums[i];
            List<Integer> temp = new ArrayList<>();
            track(nums, i, temp, ret);
        }
        return ret;
    }

    private void track(int[] nums, int index, List<Integer> current, List<List<Integer>> ret) {
        if (index > nums.length) return;

        current.add(nums[index]);
        ret.add(current);
        int last = nums[index] - 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (last == nums[i]) {
                continue;
            }
            last = nums[i];
            List<Integer> temp = new ArrayList<>();
            temp.addAll(current);
            track(nums, i, temp, ret);
        }
    }
}
