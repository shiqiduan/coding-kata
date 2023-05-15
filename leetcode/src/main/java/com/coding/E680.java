package com.coding;

public class E680 {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return validPalindrome(s, start + 1, end)
                        || validPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean validPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
