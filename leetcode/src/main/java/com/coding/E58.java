package com.coding;

public class E58 {
    public int lengthOfLastWord(String s) {
        int ret = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ' && ret != 0) {
                return ret;
            }
            if (c == ' ' && ret == 0) {
                continue;
            }
            ret++;
        }
        return ret;
    }
}
