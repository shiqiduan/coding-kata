package com.duan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) {
            int x = candidates[i];
            if (i > 0 && x <= candidates[i - 1]) {
                continue;
            }
            list.add(x);
            track(candidates, i, target, list, x, ret);
            list.remove(list.size() - 1);
        }
        return ret;
    }

    private int track(int[] candidates, int index, int target, List<Integer> list, int sum, List<List<Integer>> ret) {
        if (sum == target) {
            List<Integer> x = new ArrayList<>();
            x.addAll(list);
            ret.add(x);
            return 1;
        }
        if (sum > target) {
            return 1;
        }

        for (int i = index + 1; i < candidates.length; i++) {
            int x = candidates[i];
            if (i > index + 1 && x <= candidates[i - 1]) {
                continue;
            }
            list.add(x);
            int track = track(candidates, i, target, list, sum + candidates[i], ret);
            list.remove(list.size() - 1);
            if (track == 1) {
                break;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        M40 m = new M40();

    }
}
