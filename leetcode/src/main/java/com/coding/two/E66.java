package com.coding.two;

import java.util.Arrays;

public class E66 {
    public int[] plusOne(int[] digits) {
        int add = 1;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int x = digits[i] + add + carry;
            add = 0;
            digits[i] = x % 10;
            carry = x / 10;
        }
        if (carry > 0) {
            int[] ans = new int[digits.length + 1];
            Arrays.copyOfRange(digits, 1, digits.length);
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}
