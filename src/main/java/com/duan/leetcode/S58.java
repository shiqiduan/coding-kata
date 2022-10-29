package com.duan.leetcode;

public class S58 {
    public int lengthOfLastWord(String s) {
        int len = 0;
        s = ' ' + s;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            }
            if(s.charAt(i - 1) == ' ') {
                len = 1;
            } else {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        S58  s = new S58();
        System.out.println(s.lengthOfLastWord("hell123o wrold"));
        System.out.println(s.lengthOfLastWord("hello wrold  moon    "));
        System.out.println(s.lengthOfLastWord("luffy is still joyboy"));
    }
}
