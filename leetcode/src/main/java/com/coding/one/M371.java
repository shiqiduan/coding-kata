package com.coding.one;

public class M371 {
    public int getSum(int a, int b) {
        int carry = 0;
        while (b != 0) {
            // 是否需要进位
            carry = a & b;
            // 不考虑进位计算
            a = a ^ b;
            // 进位前移，准备参与加法
            b = carry << 1;
        }
        return a;
    }
}
