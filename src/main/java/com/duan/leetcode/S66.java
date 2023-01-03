package com.duan.leetcode;

import java.util.Arrays;

public class S66 {
    public int[] plusOne(int[] digits) {
        boolean add = false;
        digits[digits.length - 1] += 1;
        for (int i = (digits.length - 1); i >= 0; i--) {
            int current = digits[i] + ((add) ? 1 : 0);
            add = false;
            if(current >= 10) {
                current = current - 10;
                add = true;
            }
            digits[i] = current;
        }
        if(add) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                ret[i + 1] = digits[i];
            }
            return ret;
        }
        return digits;
    }

    public static void main(String[] args) {
        S66 s = new S66();

        System.out.println(Arrays.toString(s.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{1,9,9})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9,9,9})));
    }
}
