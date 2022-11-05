package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> bfs = bfs(nums, 0);
        return bfs;
    }

    private List<List<Integer>> bfs(int[] nums, int current) {
        if(current == nums.length - 1) {
            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            l.add(nums[current]);
            ret.add(l);
            return ret;
        }

        List<List<Integer>> retList = bfs(nums, current + 1);

        List<List<Integer>> tempCollect = new ArrayList<>();
        for (int i = 0; i < retList.size(); i++) {
            List<Integer> list = retList.get(i);
            for (int j = 0; j <= list.size(); j++) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(list);
                temp.add(j, nums[current]);
                tempCollect.add(temp);
            }
        }
        return tempCollect;
    }

    public static void main(String[] args) {
        S46 s = new S46();
        System.out.println(s.permute(new int[]{1,2,3}));
        System.out.println(s.permute(new int[]{1}));
        System.out.println(s.permute(new int[]{0, 1}));
    }
}
