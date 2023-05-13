package com.coding;

import java.util.HashSet;
import java.util.Set;

public class E349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> ret = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (s1.contains(nums2[i])) {
                ret.add(nums2[i]);
            }
        }

        int[] ra = new int[ret.size()];

        int i = 0;
        for (Integer x : ret) {
            ra[i] = x;
            i++;
        }
        return ra;
    }
}
