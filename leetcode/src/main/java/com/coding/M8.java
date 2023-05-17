package com.coding;

public class M8 {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean negative = false;
        boolean start = false;
        long ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!start) {
                if (c == ' ') {
                    continue;
                }
                if (c == '-') {
                    negative = true;
                } else if (c == '+') {
                    // pass
                } else {
                    i--;
                }
                start = true;
                continue;
            }
            if (!Character.isDigit(c)) {
                break;
            }

            ret = ret * 10 + Character.getNumericValue(c);
            if (negative && ret > (-(long) Integer.MIN_VALUE)) {
                return Integer.MIN_VALUE;
            }
            if (!negative && ret > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (negative) ? -(int) ret : (int) ret;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);

        M8 m = new M8();

        System.out.println(m.myAtoi(""));
        System.out.println(m.myAtoi(" "));
        System.out.println(m.myAtoi("  -"));
        System.out.println(m.myAtoi("   +"));
        System.out.println(m.myAtoi("   +123 "));
        System.out.println(m.myAtoi("   +123 av"));
        System.out.println(m.myAtoi("   +123 adf"));
        System.out.println(m.myAtoi("   -42"));
        System.out.println(m.myAtoi("   -42adaf"));
        System.out.println(m.myAtoi("   -421231231111123123121312131"));
        System.out.println(m.myAtoi("   421231111123123123121312131"));
    }
}
