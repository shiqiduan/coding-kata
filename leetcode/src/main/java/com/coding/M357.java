package com.coding;

public class M357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int ans = 10, temp = 9 * 9;
        for (int i = 2; i <= n; i++) {
            temp = temp * (10 - i + 1);
            ans = temp + ans;
        }
        return ans;
    }
}
