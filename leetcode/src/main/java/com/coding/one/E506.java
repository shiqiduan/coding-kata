package com.coding.one;

import java.util.Arrays;
import java.util.PriorityQueue;

public class E506 {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < score.length; i++) {
            queue.add(new int[]{i, score[i]});
        }
        String[] ans = new String[score.length];
        int i = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            i++;
            ans[poll[0]] = switch (i) {
                case 1 -> "Gold Medal";
                case 2 -> "Silver Medal";
                case 3 -> "Bronze Medal";
                default -> i + "";
            };
        }
        return ans;
    }

    public static void main(String[] args) {
        E506 e = new E506();
        System.out.println(Arrays.toString(e.findRelativeRanks(new int[]{
                1, 2, 3, 4, 5
        })));
    }
}
