package com.coding;

public class M7 {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            ret = ret * 10 + x % 10;
            x = x / 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(-123 / 10);
        System.out.println(-123 % 10);
    }

}
