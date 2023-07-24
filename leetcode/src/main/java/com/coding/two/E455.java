package com.coding.two;

import java.util.Arrays;

public class E455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int x = s.length - 1;
        int ans = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (x >= 0 && g[i] <= s[x]) {
                ans++;
                x--;
            }
        }
        return ans;
    }
}
