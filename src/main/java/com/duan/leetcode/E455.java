package com.duan.leetcode;

import java.util.Arrays;

public class E455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, ret = 0;
        while (i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                ret++;
                i++;
            }
            j++;
        }
        return ret;
    }

    public static void main(String[] args) {
        E455 e = new E455();
        System.out.println(e.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(e.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(e.findContentChildren(new int[]{1}, new int[]{1, 2, 3}));
        System.out.println(e.findContentChildren(new int[]{4, 6, 9}, new int[]{1, 2, 5}));
        System.out.println(e.findContentChildren(new int[]{4, 6, 9}, new int[]{}));
    }
}
