package com.coding.three;

import org.junit.Assert;

public class M91 {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        if (s.length() == 1) return 1;
        int a = 1, b = 1;
        for (int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i);
            int c = 0;
            if (curr != '0') {
                c += b;
            }
            if (s.charAt(i - 1) == '1') {
                c += a;
            }
            if (s.charAt(i - 1) == '2' && curr >= '0' && curr <= '6') {
                c += a;
            }
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        M91 m = new M91();

        Assert.assertEquals(4, m.numDecodings("2611055971756562"));
        Assert.assertEquals(2, m.numDecodings("12"));
        Assert.assertEquals(3, m.numDecodings("226"));
        Assert.assertEquals(0, m.numDecodings("06"));
        Assert.assertEquals(0, m.numDecodings("1006"));
        Assert.assertEquals(1, m.numDecodings("106"));
        Assert.assertEquals(2, m.numDecodings("136"));
    }
}
