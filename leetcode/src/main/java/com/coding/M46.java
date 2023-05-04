package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] visited = new int[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        track(result, nums, list, visited);
        return result;
    }

    private void track(List<List<Integer>> ret, int[] nums, List<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            list.add(nums[i]);
            track(ret, nums, list, visited);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        M46 m = new M46();
        System.out.println(m.permute(new int[]{1, 2, 3}));
    }
}
