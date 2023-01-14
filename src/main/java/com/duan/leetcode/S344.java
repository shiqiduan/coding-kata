package com.duan.leetcode;

public class S344 {
    public void reverseString(final char[] s) {
        if (s.length == 1) return;

        final int size = s.length;
        final int mid = size / 2;
        int l = 0, r = 0;
        if (size % 2 == 0) {
            r = size / 2;
            l = r - 1;
        } else {
            r = mid + 1;
            l = mid - 1;
        }

        while (r < s.length) {
            this.swap(s, l, r);
            r++;
            l--;
        }
    }

    private void swap(final char[] s, final int x, final int y) {
        final char temp = s[x];
        s[x] = s[y];
        s[y] = temp;
    }
}
