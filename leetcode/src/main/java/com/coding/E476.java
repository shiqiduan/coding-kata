package com.coding;

public class E476 {
    public int findComplement(int num) {
        int a = num, b = 1;
        a = a >> 1;
        while (a > 0) {
            a = a >> 1;
            b = (b << 1) + 1;
        }
        return num ^ b;
    }

    public static void main(String[] args) {
        E476 e = new E476();
        System.out.println(e.findComplement(5));
    }
}
