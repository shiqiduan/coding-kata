package com.coding;

public class E459 {
    public boolean repeatedSubstringPattern(String s) {
        String x = s + s;
        return x.substring(1, s.length() - 1).contains(s);
    }
}
