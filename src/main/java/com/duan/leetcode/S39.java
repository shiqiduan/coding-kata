package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            track(candidates, target, i, currentList, 0, retList);
        }
        return retList;
    }

    private void track(int[] candidates, int target, int index, List<Integer> currentList, int currentCount, List<List<Integer>> ret) {
        int current = candidates[index];

        int temp = currentCount + current;
        if(temp > target) {
            return;
        }
        if(temp == target) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(currentList);
            newList.add(current);
            ret.add(newList);
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            currentList.add(candidates[index]);
            currentCount = currentCount + candidates[index];
            track(candidates, target, i, currentList, currentCount, ret);
            currentList.remove(currentList.size() - 1);
            currentCount = currentCount - candidates[index];
        }
    }

    public static void main(String[] args) {
        S39 s = new S39();
        System.out.println(s.combinationSum(new int[] {2,3,6,7}, 7));
        System.out.println(s.combinationSum(new int[] {2,3,5}, 8));
        System.out.println(s.combinationSum(new int[] {2}, 1));
        System.out.println(s.combinationSum(new int[] {2}, 2));
        System.out.println(s.combinationSum(new int[] {2}, 3));
        System.out.println(s.combinationSum(new int[] {1, 2, 5}, 10));
    }
}
