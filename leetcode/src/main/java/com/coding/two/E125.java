package com.coding.two;

public class E125 {
    public boolean isPalindrome(String s) {
        int x = 0, y = s.length() - 1;
        while (x < y) {
            while (x < y && !Character.isLetter(s.charAt(x)) && !Character.isDigit(s.charAt(x))) {
                x++;
            }
            while (x < y && !Character.isLetter(s.charAt(y)) && !Character.isDigit(s.charAt(y))) {
                y--;
            }
            System.out.println(Character.toLowerCase(s.charAt(x)));
            System.out.println(Character.toLowerCase(s.charAt(y)));
            System.out.println(Character.toLowerCase(s.charAt(x)) != Character.toLowerCase(s.charAt(y)));
            if (Character.toLowerCase(s.charAt(x)) != Character.toLowerCase(s.charAt(y))) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }

    public static void main(String[] args) {
        E125 e = new E125();

        System.out.println(e.isPalindrome("OP"));
        System.out.println(e.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
