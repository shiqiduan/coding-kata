package com.duan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        track(nums, 0, list, used, ret);
        return ret;
    }

    private void track(int[] nums, int index, List<Integer> list, boolean[] used, List<List<Integer>> ret) {
        if(index == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1] || used[i]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;
            track(nums, index + 1, list, used, ret);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        M47 m = new M47();

        System.out.println(m.permuteUnique(new int[] {1, 1, 2}));
    }
}
