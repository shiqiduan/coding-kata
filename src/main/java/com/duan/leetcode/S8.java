package com.duan.leetcode;

public class S8 {
    public int myAtoi(String s) {
        int ret = 0, current = 0;
        boolean start = false, flag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ' && !start) {
                continue;
            }
            if(!start && (c == '-' || c == '+')) {
                start = true;
                if(c == '-') {
                    flag = true;
                }
                continue;
            }
            if(c >= '0' && c <= '9') {
                start = true;

                current = (flag) ? -(c - 48) : (c - 48);
                if(ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && current > 7)) {
                    return Integer.MAX_VALUE;
                }
                if(ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && current < -8)) {
                    return Integer.MIN_VALUE;
                }

                ret = ret * 10 + current;
                continue;
            }
            break;
        }
        return ret;
    }

    public static void main(String[] args) {
        S8 s = new S8();
        System.out.println(s.myAtoi("  -a123"));

        System.out.println(s.myAtoi("123"));
        System.out.println(s.myAtoi("0"));
        System.out.println(s.myAtoi("   123"));
        System.out.println(s.myAtoi("   +123"));
        System.out.println(s.myAtoi("   -123"));
        System.out.println(s.myAtoi("   2147483647 aaaa"));
        System.out.println(s.myAtoi("   2147483648 aaaa"));
        System.out.println(s.myAtoi("   2147483748 aaaa"));
        System.out.println(s.myAtoi("   -2147483648 b"));
        System.out.println(s.myAtoi("   -2147483649 aaaa"));
        System.out.println(s.myAtoi("   -2147484648 aaaa"));
        System.out.println(s.myAtoi("   +"));
        System.out.println(s.myAtoi("   -"));

        System.out.println(s.myAtoi("   -123 ada dadf 123 "));
    }
}
