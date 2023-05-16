package com.coding;

public class E1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] sorted = new int[1000 + 1];
        for (int i = 0; i < arr1.length; i++) {
            sorted[arr1[i]]++;
        }
        int[] ret = new int[arr1.length];
        int current = 0;
        for (int i = 0; i < arr2.length; i++) {
            int times = sorted[arr2[i]];
            while (times-- > 0) {
                ret[current++] = arr2[i];
            }
            sorted[arr2[i]] = 0;
        }
        for (int i = 0; i < sorted.length; i++) {
            int times = sorted[i];
            if (times <= 0) {
                continue;
            }
            while (times-- > 0) {
                ret[current++] = i;
            }
        }
        return ret;
    }
}
