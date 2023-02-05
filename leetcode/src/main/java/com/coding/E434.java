package com.coding;

public class E434 {
    public int countSegments(String s) {
        String[] s1 = s.split(" ");
        int count = 0;
        for (int i = 0; i < s1.length; i++) {
            if(s1[i].trim().length() != 0) {
                count++;
            }
        }
        return count;
    }
}
