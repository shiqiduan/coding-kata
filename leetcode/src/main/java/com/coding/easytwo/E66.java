package com.coding.easytwo;

public class E66 {

    /**
     * 紧扣题意，理解更透彻
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 类似模版
     */
    public int[] plusOne1(int[] digits) {
        int a = digits.length - 1, carry = 0, add = 1;
        while (a >= 0) {
            int av = digits[a];
            int s = av + add + carry;
            digits[a] = s % 10;
            carry = s / 10;
            a--;
            add = 0;
        }
        if (carry > 0) {
            int[] ans = new int[digits.length + 1];
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            ans[0] = carry;
            return ans;
        }
        return digits;
    }
}
