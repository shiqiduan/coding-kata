package com.duan.leetcode;

public class E374 {
    public int guessNumber(int n) {
        int a = 1, b = n;
        while (true) {
            int mid = a + (b - a) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            }
            if (guess == -1) {
                b = mid;
            }
            if (guess == 1) {
                if (mid == a) {
                    a = a + 1;
                } else {
                    a = mid;
                }
            }
        }
    }

    private int guess(int num) {
        return 0;
    }
}
