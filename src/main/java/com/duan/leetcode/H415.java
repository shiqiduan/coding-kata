package com.duan.leetcode;

public class H415 {
    public String addStrings(String num1, String num2) {
        int len = Math.max(num1.length(), num2.length());
        int s1 = num1.length(), s2 = num2.length();
        int add = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= len; i++) {
            int index1 = s1 - i;
            int a = 0, b = 0;
            if (index1 >= 0) {
                a = num1.charAt(index1) - 48;
            }
            int index2 = s2 - i;
            if (index2 >= 0) {
                b = num2.charAt(index2) - 48;
            }

            int c = a + b + add;

            if (c >= 10) {
                add = 1;
                c = c - 10;
            } else {
                add = 0;
            }

            sb.append(c);
        }

        if (add > 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}