package com.coding;

public class E557 {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int start = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (start == Integer.MAX_VALUE) {
                    start = i;
                }
            } else {
                swap(c, start, i - 1);
                start = Integer.MAX_VALUE;
            }
        }
        swap(c, start, s.length() - 1);
        return new String(c);
    }

    private void swap(char[] c, int a, int b) {
        while (a < b) {
            char temp = c[a];
            c[a] = c[b];
            c[b] = temp;
            a++;
            b--;
        }
    }
}
