package com.duan.leetcode;

public class S7 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE/10 && pop > 7)) {
                return 0;
            }
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x = x / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        S7 s = new S7();
        System.out.println(s.reverse(-2147483648));

        System.out.println(s.reverse(123));
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(120));
        System.out.println(s.reverse(100));
        System.out.println(s.reverse(0));
        System.out.println(s.reverse(-100));
    }
}
