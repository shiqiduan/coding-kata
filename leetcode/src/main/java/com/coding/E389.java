package com.coding;

import java.util.Arrays;

public class E389 {
    public char findTheDifference(String s, String t) {
        char[] ta = t.toCharArray();
        Arrays.sort(ta);
        char[] sa = s.toCharArray();
        Arrays.sort(sa);
        int i = 0;
        for (; i < s.length(); i++) {
            if (ta[i] != sa[i]) {
                return ta[i];
            }
        }
        return ta[i];
    }
}
