package com.coding.two;

import java.util.ArrayList;
import java.util.List;

public class M39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, 0, 0, list, ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int index, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i, sum, list, ans);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        M39 m = new M39();
        System.out.println(m.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
