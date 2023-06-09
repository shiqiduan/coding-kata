package com.coding;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class M983 {

    /**
     * 动态规划
     * 1. dp[i] 从这天开始到年底的最低成本， 从后往前. 今天买多少，依赖后面的计划
     * 2. 如果含这一天，dp[i] = min(cost[j] + dp[i - j])
     * 3. 不含这一天，dp[i] = dp[i + 1];
     */
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = Arrays.stream(days).boxed().collect(Collectors.toSet());

        int[] dp = new int[366];
        for (int i = 365; i >= 0; i--) {
            if (!set.contains(i)) {
                dp[i] = (i + 1 > 365) ? 0 : dp[i + 1];
            } else {
                dp[i] = Integer.MAX_VALUE;
                dp[i] = Math.min(dp[i], costs[0] + ((i + 1 > 365) ? 0 : dp[i + 1]));
                dp[i] = Math.min(dp[i], costs[1] + ((i + 7 > 365) ? 0 : dp[i + 7]));
                dp[i] = Math.min(dp[i], costs[2] + ((i + 30 > 365) ? 0 : dp[i + 30]));
            }
        }
        return dp[1];
    }
}
