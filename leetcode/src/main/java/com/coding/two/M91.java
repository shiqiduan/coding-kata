package com.coding.two;

import org.junit.Assert;

public class M91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int a = 1, b = 1;

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i), p = s.charAt(i - 1);

            int c = 0;

            if (curr == '0') {
                if (p == '1' || p == '2') {
                    c = a;
                }
            } else {
                c = b;
                if (p == '1' || p == '2' && curr <= '6') {
                    c += a;
                }
            }
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        M91 m = new M91();

        Assert.assertEquals(2, m.numDecodings("12"));
        Assert.assertEquals(3, m.numDecodings("226"));
        Assert.assertEquals(0, m.numDecodings("06"));
        Assert.assertEquals(0, m.numDecodings("1006"));
        Assert.assertEquals(1, m.numDecodings("106"));
        Assert.assertEquals(2, m.numDecodings("136"));
    }
}
