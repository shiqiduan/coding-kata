package com.duan;

public class S344 {
    public void reverseString(char[] s) {
        if(s.length == 1) return;

        int size = s.length;
        int mid = size / 2;
        int l = 0, r = 0;
        if(size % 2 == 0) {
            r = size / 2;
            l = r - 1;
        } else {
            r = mid + 1;
            l = mid - 1;
        }

        while (r < s.length) {
            swap(s, l, r);
            r++;
            l--;
        }
    }

    private void swap(char[] s, int x, int y) {
        char temp = s[x];
        s[x] = s[y];
        s[y] = temp;
    }
}
