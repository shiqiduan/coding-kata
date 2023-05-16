package com.coding;

public class E190 {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            ret |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return ret;
    }
}
