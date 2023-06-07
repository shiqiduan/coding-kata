package com.coding.easytwo;

public class E9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int origin = x;
        int y = 0;
        while (x >= 10) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        y = y * 10 + x;
        return origin == y;
    }

    public static void main(String[] args) {
        E9 e = new E9();

        System.out.println(e.isPalindrome(121));
        System.out.println(e.isPalindrome(-121));
        System.out.println(e.isPalindrome(10));
        System.out.println(e.isPalindrome(0));
    }
}
