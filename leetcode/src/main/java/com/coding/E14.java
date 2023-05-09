package com.coding;

public class E14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        int len = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            len = Math.min(strs[i].length(), len);
        }

        int ret = 0;
        while (ret < len) {
            char x = strs[0].charAt(ret);
            for (int i = 1; i < strs.length; i++) {
                if (x != strs[i].charAt(ret)) {
                    return strs[0].substring(0, ret);
                }
            }
            ret++;
        }
        return strs[0].substring(0, len);
    }

    public static void main(String[] args) {
        E14 e = new E14();
        System.out.println(e.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
