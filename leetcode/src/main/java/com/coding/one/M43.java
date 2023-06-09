package com.coding.one;

public class M43 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = Character.getNumericValue(num1.charAt(i));
            int carry = 0, b = num2.length() - 1;
            StringBuilder t = new StringBuilder();
            while (b >= 0 || carry > 0) {
                int bv = (b >= 0) ? Character.getNumericValue(num2.charAt(b)) : 0;
                int s = x * bv + carry;
                t.append(s % 10);
                carry = s / 10;
                b--;
            }
            t.reverse();
            for (int j = i; j < num1.length() - 1; j++) {
                t.append("0");
            }

            sb = sum(sb, t);
        }
        return sb.toString();
    }

    private StringBuilder sum(StringBuilder num1, StringBuilder num2) {
        StringBuilder sb = new StringBuilder();
        int a = num1.length() - 1, b = num2.length() - 1, carry = 0;
        while (a >= 0 || b >= 0 || carry > 0) {
            int av = (a >= 0) ? Character.getNumericValue(num1.charAt(a)) : 0;
            int bv = (b >= 0) ? Character.getNumericValue(num2.charAt(b)) : 0;
            int s = av + bv + carry;
            sb.append(s % 10);
            carry = s / 10;
            a--;
            b--;
        }
        return sb.reverse();
    }
}
