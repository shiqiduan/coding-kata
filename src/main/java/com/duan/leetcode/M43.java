package com.duan.leetcode;

public class M43 {
    public String multiply(String num1, String num2) {
        StringBuilder ret = new StringBuilder();
        int j = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            char c = num1.charAt(i);
            ret = add(ret, multiply(num2, c, j));
            j++;
        }
        ret.reverse();
        if (ret.charAt(0) == '0') {
            return "0";
        }
        return ret.toString();
    }

    private StringBuilder multiply(String num1, char c, int index) {
        int b = c - 48;
        int add = 0;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < index; i++) {
            ret.append(0);
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            char x = num1.charAt(i);
            int a = x - 48;
            int d = a * b + add;
            ret.append(d % 10);
            add = d / 10;
        }
        if (add > 0) {
            ret.append(add);
        }
        return ret;
    }

    private StringBuilder add(StringBuilder a, StringBuilder b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;

        StringBuilder ret = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int add = 0;
        for (int i = 0; i < len; i++) {
            int x = 0, y = 0;
            if (i < a.length()) {
                x = a.charAt(i) - 48;
            }
            if (i < b.length()) {
                y = b.charAt(i) - 48;
            }
            int sum = x + y + add;
            ret.append(sum % 10);
            add = sum / 10;
        }
        if (add > 0) {
            ret.append(1);
        }
        return ret;
    }

    public static void main(String[] args) {
        M43 m = new M43();

        System.out.println(m.multiply("408", "5"));
    }
}
