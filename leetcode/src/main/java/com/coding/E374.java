package com.coding;

public class E374 {
    public int guessNumber(int n) {
        int s = 1, e = n;
        while (s < e) {
            int mid = s + (e - s) / 2 + 1;
            int ret = guess(mid);
            if (ret == 0) {
                return mid;
            } else if (ret == -1) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    private int guess(int n) {
        return 0;
    }
}
