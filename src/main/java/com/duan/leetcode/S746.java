package com.duan.leetcode;

public class S746 {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for (int i = 2; i <= cost.length; i++) {
            int c = Math.min(a + cost[i-2], b + cost[i-1]);
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        S746 s = new S746();
        System.out.println(s.minCostClimbingStairs(new int[]{10,15,10}));
        System.out.println(s.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
