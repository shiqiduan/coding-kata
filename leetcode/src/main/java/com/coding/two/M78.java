package com.coding.two;

import java.util.ArrayList;
import java.util.List;

public class M78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list, ans);
        ans.add(new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int i, List<Integer> sub, List<List<Integer>> res) {
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            sub.add(nums[j]);
            res.add(new ArrayList<>(sub));
            backtrack(nums, j + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }
}
