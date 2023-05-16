package com.coding;

public class E1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; i + j <= n; j = j + 2) {
                int end = i + j - 1;
                sum += prefixSums[end + 1] - prefixSums[i];
            }
        }
        return sum;
    }
}
