package com.coding;

public class E1221 {
    public int balancedStringSplit(String s) {
        int ret = 0;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                ret++;
                l = 0;
                r = 0;
            }
        }
        return ret;
    }
}
