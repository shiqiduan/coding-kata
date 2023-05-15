package com.coding;

import java.util.Arrays;

public class E455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int ret = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
                j++;
                ret++;
            } else {
                j++;
            }
        }
        return ret;
    }
}
