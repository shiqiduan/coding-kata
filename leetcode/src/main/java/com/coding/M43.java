package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M43 {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        List<Integer> sum = new ArrayList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            char c = num2.charAt(i);
            if (Character.getNumericValue(c) == 0) {
                continue;
            }
            List<Integer> multi = multi(num1.toCharArray(), c, num2.length() - i - 1);
            sum = add(sum, multi);
            System.out.println(sum + " " + multi);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = sum.size() - 1; i >= 0; i--) {
            sb.append(sum.get(i));
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }

    private List<Integer> multi(char[] chars, char c, int x) {
        List<Integer> ret = new ArrayList<>();
        if (x > 0) {
            while (x > 0) {
                ret.add(0);
                x--;
            }
        }
        int carry = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int a = Character.getNumericValue(chars[i]);
            int b = Character.getNumericValue(c);
            int r = a * b + carry;
            ret.add(r % 10);
            carry = r / 10;
        }
        if (carry > 0) {
            ret.add(carry);
        }
        return ret;
    }

    private List<Integer> add(List<Integer> a, List<Integer> b) {
        if (a.size() == 0) return b;
        if (b.size() == 0) return a;

        int as = 0, bs = 0;
        int carry = 0;
        List<Integer> ret = new ArrayList<>();
        while (as < a.size() || bs < b.size()) {
            int av = (as < a.size()) ? a.get(as) : 0;
            int bv = (bs < b.size()) ? b.get(bs) : 0;
            int r = av + bv + carry;
            ret.add(r % 10);
            carry = r / 10;
            as++;
            bs++;
        }
        if (carry > 0) {
            ret.add(carry);
        }
        return ret;
    }

    public static void main(String[] args) {
        M43 m = new M43();
        System.out.println(m.multiply("123", "456"));
        System.out.println(m.multiply("999", "99"));
        System.out.println(m.multiply("999", "9999"));
    }
}
