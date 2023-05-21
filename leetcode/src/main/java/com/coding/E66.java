package com.coding;

public class E66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int s = digits[i] + carry;
            if (s >= 10) {
                carry = 1;
                digits[i] = s - 10;
            } else {
                carry = 0;
                digits[i] = s;
                break;
            }
        }
        if (carry > 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            System.arraycopy(digits, 0, ret, 1, digits.length);
            digits = ret;
        }
        return digits;
    }
}
