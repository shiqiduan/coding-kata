package com.coding.two.binarytree;

public class M96 {
    public int numTrees(int n) {
        return numTrees(0, n - 1);
    }

    private int numTrees(int s, int e) {
        if (s >= e) return 1;

        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += numTrees(s, i - 1) * numTrees(i + 1, e);
        }
        return sum;
    }

    public int numTrees1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
