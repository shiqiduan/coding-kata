package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, 1, k, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int target, int index, int k, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == k && target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (!(target > 0 && list.size() < k)) {
            return;
        }

        for (int i = index; i <= 9; i++) {
            list.add(i);
            dfs(target - i, i + 1, k, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
