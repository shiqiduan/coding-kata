package com.duan.leetcode;

public class E392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() != 0 && s.length() > t.length()) return false;

        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index++;
                if (index >= s.length()) return true;
            }
        }
        return false;
    }
}
