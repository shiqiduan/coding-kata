package com.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;
            dfs(nums, used, list, ans);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        M47 m = new M47();

        System.out.println(m.permuteUnique(new int[]{1, 1, 2}));
    }
}
