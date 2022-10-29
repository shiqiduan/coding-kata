package com.duan.leetcode;

public class S14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];

        int maxLen = strs[0].length();
        String maxStr = strs[0];
        for (String s : strs) {
            if(s.length() < maxLen) {
                maxLen = s.length();
                maxStr = s;
            }
        }
        for (int i = 0; i < maxLen; i++) {
            char a = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != a) {
                    if (i == 0) {
                        return "";
                    } else {
                        return strs[0].substring(0, i);
                    }
                }
            }
        }
        return maxStr;
    }
}
