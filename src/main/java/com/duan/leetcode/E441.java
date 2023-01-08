package com.duan.leetcode;

import java.util.Stack;

public class E441 {
    public int arrangeCoins(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = (end - start + 1) / 2 + start;

            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
