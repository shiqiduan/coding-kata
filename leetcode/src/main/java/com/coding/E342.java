package com.coding;

public class E342 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0XAAAAAAAA) == 0;
    }
}
