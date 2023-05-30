package com.coding;

public class M28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            int a = i, b = 0;
            while (b < needle.length() && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if (b == needle.length()) return i;
        }
        return -1;
    }
}
