package com.coding.easytwo;

public class E88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1, b = n - 1, c = m + n;
        while (c > 0) {
            c--;
            if (a >= 0 && b >= 0) {
                if (nums1[a] >= nums2[b]) {
                    nums1[c] = nums1[a];
                    a--;
                } else {
                    nums1[c] = nums2[b];
                    b--;
                }
            } else if (b >= 0) {
                nums1[c] = nums2[b];
                b--;
            } else if (a >= 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        E88 e = new E88();

        e.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
