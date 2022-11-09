package com.duan.leetcode;

public class M5 {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String ret = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String palindrome = getPalindrome(s, i, true);
            if(palindrome.length() > maxLen) {
                ret = palindrome;
                maxLen = palindrome.length();
            }
            palindrome = getPalindrome(s, i, false);
            if(palindrome.length() > maxLen) {
                ret = palindrome;
                maxLen = palindrome.length();
            }
        }
        return ret;
    }

    private String getPalindrome(String s, int index, boolean mid) {
        int l = index, r = index;
        if(!mid) {
            l = index;
            r = index + 1;
        }
        while (l >= 0 && r < s.length()) {
            if(s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                return s.substring(l+1, r);
            }
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        M5 m = new M5();
        System.out.println(m.longestPalindrome("babad"));
        System.out.println(m.longestPalindrome("cbbd"));
        System.out.println(m.longestPalindrome("cbbd"));
    }
}
