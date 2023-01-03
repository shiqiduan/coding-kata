package com.duan.leetcode;

public class S125 {
    public boolean isPalindrome(String s) {
        if(s.length() == 1) return true;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (!Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start)) && start < end) {
                start++;
            }
            while (!Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end)) && start < end) {
                end--;
            }
            System.out.println(s.charAt(start) + " " + s.charAt(end));
            int a = Character.toLowerCase(s.charAt(start));
            int b = Character.toLowerCase(s.charAt(end));
            if(a != b) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        S125 s = new S125();

        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(s.isPalindrome("race a car"));
        System.out.println(s.isPalindrome(" "));
        System.out.println(s.isPalindrome("a "));
        System.out.println(s.isPalindrome(".,"));
        System.out.println(s.isPalindrome("OP"));
        System.out.println(s.isPalindrome("0P"));
        System.out.println(s.isPalindrome("ab2a"));
    }
}
