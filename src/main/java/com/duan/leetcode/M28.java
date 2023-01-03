package com.duan.leetcode;

/**
 * 字符串匹配，KMP 算法.
 */
public class M28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; i++) {
            // 扎到第一个字符匹配的位置
            if (haystack.charAt(i) != needle.charAt(0)) {
                while (++i <= max && haystack.charAt(i) != needle.charAt(0)) ;
            }

            if (i > max) return -1;
            int k = 1;
            for (; k < needle.length(); k++) {
                if (haystack.charAt(i + k) != needle.charAt(k)) {
                    break;
                }
            }
            if (k == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        M28 m = new M28();

        System.out.println(m.strStr("sadbutsad", "sad"));
        System.out.println(m.strStr("ssadbutsad", "sad"));
        System.out.println(m.strStr("leetcode", "leeto"));
    }
}
