package com.duan.leetcode;

public class S541 {
    public String reverseStr(String s, int k) {
        if(s.length() == 1) return s;

        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); ) {
            int start = i;
            int mid = start + k;

            if(mid <= s.length()) {
                reverse(chars, start, mid - 1);
            } else {
                reverse(chars, start, s.length() - 1);
            }
            i += 2 * k;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int x, int y) {
        for (int i = 0; i < (y - x + 1)/2; i++) {
            swap(chars, x + i, y - i);
        }
    }

    private void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    public static void main(String[] args) {
        S541 s = new S541();

        System.out.println(s.reverseStr("abcdef", 2));
        System.out.println(s.reverseStr("abcde", 2));
        System.out.println(s.reverseStr("abcdefgf", 2));
        System.out.println(s.reverseStr("abcdefg", 2));
        System.out.println(s.reverseStr("abcd", 2));
        System.out.println(s.reverseStr("abc", 2));
        System.out.println(s.reverseStr("ab", 2));
        System.out.println(s.reverseStr("ab", 3));
        System.out.println(s.reverseStr("a", 2));
        System.out.println(s.reverseStr("a", 3));
    }
}
