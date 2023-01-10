package com.duan.leetcode;

import java.util.*;

public class E599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            String[] temp = list1;
            list1 = list2;
            list2 = temp;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int indexSum = Integer.MAX_VALUE;
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            String key = list2[i];

            Integer index1 = map.get(key);
            if (index1 == null) {
                continue;
            }

            int tempSum = index1 + i;
            if (tempSum == indexSum) {
                ret.add(key);
            } else if (tempSum < indexSum) {
                ret = new ArrayList<>();
                ret.add(key);
                indexSum = tempSum;
            }
        }
        return ret.toArray(new String[]{});
    }
}
