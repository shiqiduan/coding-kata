package com.coding;

public class E231 {
    public boolean isPowerOfTwo1(int n) {
        if (n < 1) return false;
        if (n == 1) return true;

        if (n % 2 != 0) return false;

        return isPowerOfTwo(n / 2);
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
