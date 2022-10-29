package com.duan.leetcode;

public class S9 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String str = x + "";
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if(str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        S9 s = new S9();
        System.out.println(s.isPalindrome(1) + " = true");
        System.out.println(s.isPalindrome(10) + " = false");
        System.out.println(s.isPalindrome(101) + " = true");
        System.out.println(s.isPalindrome(1001) + " = true");
        System.out.println(s.isPalindrome(1011) + " = false");
        System.out.println(s.isPalindrome(-1) + " = false");
    }
}
