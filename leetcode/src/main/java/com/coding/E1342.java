package com.coding;

public class E1342 {
    public int numberOfSteps(int num) {
        int ret = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            ret++;
        }
        return ret;
    }
}
