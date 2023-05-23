package com.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        track(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void track(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            track(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        M90 m = new M90();
        System.out.println(m.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
