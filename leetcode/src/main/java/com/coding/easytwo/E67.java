package com.coding.easytwo;

public class E67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int x = a.length() - 1, y = b.length() - 1;
        int carry = 0;
        while (x >= 0 || y >= 0) {
            int xv = (x >= 0) ? Character.getNumericValue(a.charAt(x)) : 0;
            int yv = (y >= 0) ? Character.getNumericValue(b.charAt(y)) : 0;
            int c = xv + yv + carry;
            sb.append(c % 2);
            carry = c / 2;
            x--;
            y--;
        }
        if (carry > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
