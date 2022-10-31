package com.duan.leetcode;

public class S557 {
    public String reverseWords(String s) {
        if(s.length() == 1) return s;
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverse(chars, start, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int x, int y) {
        if(x >= y) return;
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
        S557 s = new S557();
        System.out.println(s.reverseWords("Let's take LeetCode contest"));
    }
}
