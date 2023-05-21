package com.coding;

import java.util.HashSet;
import java.util.Set;

public class E345 {
    private final Set<Character> set = new HashSet<Character>();

    {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
    }

    public String reverseVowels(String s) {
        char[] ret = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !set.contains(s.charAt(l))) {
                l++;
            }
            while (l < r && !set.contains(s.charAt(r))) {
                r--;
            }
            swap(ret, l, r);
            l++;
            r--;
        }
        return new String(ret);
    }

    private void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
