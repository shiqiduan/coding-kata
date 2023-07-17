package com.coding.two;

import java.util.Arrays;

public class E338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        E338 e = new E338();
        System.out.println(Arrays.toString(e.countBits(1)));
        System.out.println(Arrays.toString(e.countBits(2)));
        System.out.println(Arrays.toString(e.countBits(5)));
    }
}
