package com.duan.leetcode;

import java.util.*;

public class S349Easy {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] l = nums1, s = nums2;
        if(l.length < s.length) {
            l = nums2;
            s = nums1;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer i : s) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        List<Integer> ret = new ArrayList<>();
        for(Integer i : l) {
            if(countMap.containsKey(i)) {
                ret.add(i);
                Integer count = countMap.get(i);
                if(count == 1) {
                    countMap.remove(i);
                } else {
                    countMap.put(i, count - 1);
                }
            }
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        S349Easy s = new S349Easy();
//        System.out.println(Arrays.toString(s.intersection(new int[]{4,4,9,5}, new int[]{9,4,9,8,4})));
    }
}
