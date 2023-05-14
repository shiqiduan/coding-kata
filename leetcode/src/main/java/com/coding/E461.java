package com.coding;

public class E461 {
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int ret = 0;
        while (a != 0) {
            ret += a & 1;
            a >>= 1;
        }
        return ret;
    }
}
