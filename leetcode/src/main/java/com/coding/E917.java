package com.coding;

public class E917 {
    public String reverseOnlyLetters(String s) {
        int a = 0, b = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (a < b) {
            while (a < b && a < s.length() && !Character.isLetter(s.charAt(a))) {
                a++;
            }
            while (a < b && b >= 0 && !Character.isLetter(s.charAt(b))) {
                b--;
            }
            if (a >= b) {
                return new String(charArray);
            }
            char temp = charArray[a];
            charArray[a] = charArray[b];
            charArray[b] = temp;
            a++;
            b--;
        }
        return new String(charArray);
    }
}
