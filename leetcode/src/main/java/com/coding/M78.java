package com.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        track(nums, 0, result, list);
        return result;
    }

    private void track(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            track(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
