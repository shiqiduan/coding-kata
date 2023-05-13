package com.coding;

public class E278 {
    public int firstBadVersion(int n) {
        int a = 0, b = n;
        while (a < b) {
            int mid = a + (b - a) / 2;
            if (isBadVersion(mid)) {
                b = mid;
            } else {
                a = mid + 1;
            }
        }
        return a;
    }

    private boolean isBadVersion(int v) {
        return true;
    }
}
