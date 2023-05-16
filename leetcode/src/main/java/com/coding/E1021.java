package com.coding;

public class E1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder ret = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                len++;
            } else {
                len--;
            }
            temp.append(c);
            if (len == 0) {
                ret.append(temp.substring(1, temp.length() - 1));
                temp = new StringBuilder();
            }
        }
        return ret.toString();
    }
}
