package com.duan.leetcode;

public class S67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int alen = a.length() - 1, blen = b.length() - 1;
        while (alen >= 0 || blen >= 0) {
            if(alen >= 0) {
                carry += a.charAt(alen) - '0';
            }
            if(blen >= 0) {
                carry += b.charAt(blen) - '0';
            }
            sb.append((carry % 2));
            carry /= 2;
            alen--;
            blen--;
        }
        if(carry > 0) {
            sb.append(1);
        }
        sb.reverse();
        return sb.toString();
    }
}
