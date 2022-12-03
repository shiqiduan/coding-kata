package com.duan.leetcode;

import org.junit.Assert;

public class E605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int next = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len - 1; i++) {
            if (next == i) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    next += 2;
                } else if (flowerbed[i] == 1 && flowerbed[i + 1] == 0) {
                    next += 2;
                } else {
                    next += 3;
                }
            }
        }
        if (next == (len - 1) && flowerbed[len - 1] == 0) {
            n--;
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        E605 e = new E605();

        Assert.assertTrue(e.canPlaceFlowers(new int[]{0}, 1));
        Assert.assertTrue(e.canPlaceFlowers(new int[]{0, 0}, 1));
        Assert.assertFalse(e.canPlaceFlowers(new int[]{0, 0}, 2));
        Assert.assertTrue(e.canPlaceFlowers(new int[]{0, 0, 0}, 2));

        Assert.assertTrue(e.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        Assert.assertFalse(e.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        Assert.assertFalse(e.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        Assert.assertTrue(e.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 1}, 2));
    }
}
