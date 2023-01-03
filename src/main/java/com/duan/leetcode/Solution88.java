package com.duan.leetcode;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n <= 0) return;

        int x = m - 1;
        int y = n - 1;
        int z = nums1.length - 1;

        while (x >= 0 && y >= 0) {
            if(nums1[x] >= nums2[y]) {
                nums1[z] = nums1[x];
                z--;
                x--;
            } else {
                nums1[z] = nums2[y];
                z--;
                y--;
            }
        }
        if(y < 0) {
            return;
        }
        if(x < 0) {
            for (int i = y; i >= 0 ; i--) {
                nums1[z] = nums2[i];
                z--;
            }
        }
        return;
    }
}
