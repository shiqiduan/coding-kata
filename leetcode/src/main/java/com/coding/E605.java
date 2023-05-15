package com.coding;

public class E605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if ((i - 1) >= 0) {
                    flowerbed[i - 1] = 2;
                }
                if ((i + 1) < flowerbed.length) {
                    flowerbed[i + 1] = 2;
                }
            }
            if (flowerbed[i] == 0) {
                if ((i + 1) >= flowerbed.length) {
                    n--;
                    continue;
                }
                if (flowerbed[i + 1] != 1) {
                    n--;
                    flowerbed[i + 1] = 2;
                }
            }
        }
        return n <= 0;
    }
}
