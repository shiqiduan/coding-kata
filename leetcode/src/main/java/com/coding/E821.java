package com.coding;

import java.util.Arrays;

public class E821 {
    public int[] shortestToChar(String s, char c) {
        int[] ret = new int[s.length()];
        Arrays.fill(ret, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t != c) {
                continue;
            }
            ret[i] = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == c) {
                    break;
                }
                ret[j] = Math.min(ret[j], i - j);
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    break;
                }
                ret[j] = Math.min(ret[j], j - i);
            }
        }
        return ret;
    }
}
