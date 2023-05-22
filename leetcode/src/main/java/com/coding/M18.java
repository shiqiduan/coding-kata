package com.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        track(nums, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void track(int[] nums, long target, int index, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == 4) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            list.add(nums[i]);
            track(nums, target - nums[i], i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
