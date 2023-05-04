package com.coding;

/**
 * 动态规划
 */
public class E746 {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for (int i = 2; i <= cost.length; i++) {
            int c = Math.min(b + cost[i - 1], a + cost[i - 2]);
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        E746 e = new E746();
        System.out.println(e.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(e.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
