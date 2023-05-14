package com.coding;

public class E415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || add > 0) {
            int a = (i >= 0) ? Character.getNumericValue(num1.charAt(i)) : 0;
            int b = (j >= 0) ? Character.getNumericValue(num2.charAt(j)) : 0;
            int c = a + b + add;
            sb.append(c % 10);
            add = c / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
