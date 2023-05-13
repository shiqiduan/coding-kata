package com.coding;

public class E258 {
    public int addDigits(int num) {
        if (num < 10) return num;
        return addDigits(num / 10 + num % 10);
    }

    public int addDigits1(int num) {
        if (num < 10) return num;
        while (num >= 10) {

        }
        return num;
    }
}
