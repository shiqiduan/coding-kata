package com.duan.leetcode;

import java.util.Arrays;

public class M45 {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int step = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    public int jump1(int[] nums) {
        int[] jumps = new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int x = nums[i];
            for (int j = 1; j <= x && (i + j) <= (nums.length - 1); j++) {
                jumps[i + j] = Math.min(jumps[i + j], jumps[i] + 1);
            }
            if (jumps[nums.length - 1] == jumps[i] + 1) {
                return jumps[nums.length - 1];
            }
        }
        return jumps[nums.length - 1];
    }

    public static void main(String[] args) {
        M45 m = new M45();

        System.out.println(m.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(m.jump(new int[]{2, 1, 3, 1, 4}));
    }
}
