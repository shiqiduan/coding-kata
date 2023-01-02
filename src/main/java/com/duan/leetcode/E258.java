package com.duan.leetcode;

public class E258 {
    public int addDigits(int num) {
        while (num >= 10) {
            String str = "" + num;
            num = 0;
            for (int i = 0; i < str.length(); i++) {
                num += str.charAt(i) - 48;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        E258 e = new E258();

        System.out.println(e.addDigits(10));
        System.out.println(e.addDigits(38));
        System.out.println(e.addDigits(0));
    }
}
