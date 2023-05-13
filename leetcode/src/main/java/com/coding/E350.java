package com.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0, b = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] == nums2[b]) {
                list.add(nums1[a]);
                a++;
                b++;
            } else if (nums1[a] > nums2[b]) {
                b++;
            } else {
                a++;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
