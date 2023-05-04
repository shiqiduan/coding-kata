package com.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);

        List<Integer> list = new ArrayList<>();
        track(candidates, 0, target, result, list);
        return result;
    }

    private boolean track(int[] candidates, int start, int target, List<List<Integer>> ret,
                          List<Integer> list) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return false;
        }
        if (target < 0) {
            return false;
        }
        for (int i = start; i < candidates.length; i++) {
            if ((target - candidates[i]) < 0) {
                break;
            }
            list.add(candidates[i]);
            track(candidates, i, target - candidates[i], ret, list);
            list.remove(list.size() - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        M39 m = new M39();
        System.out.println(m.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
