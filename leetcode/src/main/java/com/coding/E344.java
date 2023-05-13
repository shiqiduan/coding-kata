package com.coding;

public class E344 {
    public void reverseString(char[] s) {
        int a = 0, b = s.length - 1;

        while (a < b) {
            char temp = s[a];
            s[a] = s[b];
            s[b] = temp;
            a++;
            b--;
        }
    }
}
