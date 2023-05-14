package com.coding;

public class E541 {
    public String reverseStr(String s, int k) {
        char[] sc = s.toCharArray();
        for (int i = 0; i < s.length(); i = i + 2 * k) {
            reverse(sc, i, Math.min(i + k - 1, s.length() - 1));
        }
        return new String(sc);
    }

    private void reverse(char[] sc, int s, int e) {
        while (s < e) {
            char temp = sc[s];
            sc[s] = sc[e];
            sc[e] = temp;
            s++;
            e--;
        }
    }
}
