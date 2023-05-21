package com.coding;

public class E88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        while (m > 0 && n > 0) {
            int a = nums1[m - 1];
            int b = nums2[n - 1];
            if (b >= a) {
                nums1[last--] = b;
                n--;
            } else {
                nums1[last--] = a;
                m--;
            }
        }
        if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
    }
}
