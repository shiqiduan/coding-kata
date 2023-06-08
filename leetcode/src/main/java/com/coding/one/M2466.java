package com.coding.one;

import org.junit.Assert;

/**
 * 爬楼梯变种
 */
public class M2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = dp[i] + dp[i - zero];
            }
            if (i >= one) {
                dp[i] = dp[i] + dp[i - one];
            }
            dp[i] = dp[i] % 1000000007;
        }
        long ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dp[i];
        }
        return (int) (ans % 1000000007);
    }

    public static void main(String[] args) {
        M2466 m = new M2466();

        Assert.assertEquals(764262396, m.countGoodStrings(200, 200, 10, 1));
        Assert.assertEquals(873327137, m.countGoodStrings(500, 500, 5, 2));
        Assert.assertEquals(976371285, m.countGoodStrings(100000, 100000, 1000, 1000));
    }
}
