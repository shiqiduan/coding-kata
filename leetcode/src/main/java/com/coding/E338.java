package com.coding;

import java.util.Arrays;

public class E338 {
    public int[] countBits(int n) {
        if (n == 0) return new int[]{0};
        int[] ret = new int[n + 1];
        ret[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                ret[i] = ret[i - 1] + 1;
            } else {
                ret[i] = ret[i / 2];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        E338 e = new E338();
        System.out.println(Arrays.toString(e.countBits(1)));
        System.out.println(Arrays.toString(e.countBits(2)));
        System.out.println(Arrays.toString(e.countBits(5)));
    }
}
