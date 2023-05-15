package com.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, int[]> map = new HashMap<String, int[]>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], new int[]{i, -1});
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int[] ints = map.get(list2[i]);
                ints[1] = (i + ints[0]);
                map.put(list2[i], ints);

                min = Math.min(min, ints[1]);
            }
        }
        List<String> ret = new ArrayList<>();
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            if (entry.getValue()[1] == min) {
                ret.add(entry.getKey());
            }
        }
        return ret.toArray(new String[]{});
    }
}
