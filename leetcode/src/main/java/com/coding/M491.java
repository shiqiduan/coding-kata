package com.coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        find(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void find(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() >= 2) {
            ans.add(new ArrayList<>(list));
        }

        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!list.isEmpty() && (nums[i] < list.get(list.size() - 1))) {
                continue;
            }
            if (used.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            used.add(nums[i]);
            find(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
