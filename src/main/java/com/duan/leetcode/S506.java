package com.duan.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S506 {
    public String[] findRelativeRanks(int[] score) {
        int[] copy = score.clone();
        Arrays.sort(copy);
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            rankMap.put(copy[i], score.length - i);
        }

        String[] ret = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = rankMap.get(score[i]);
            switch (rank) {
                case 1:
                    ret[i] = "Gold Medal";
                    break;
                case 2:
                    ret[i] = "Silver Medal";
                    break;
                case 3:
                    ret[i] = "Bronze Medal";
                    break;
                default:
                    ret[i] = rank + "";
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        S506 s = new S506();
        System.out.println(Arrays.toString(s.findRelativeRanks(new int[]{5,4,3,2,1})));
    }
}
