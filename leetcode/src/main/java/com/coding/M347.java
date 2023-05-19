package com.coding;

import java.util.*;

public class M347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> counts = new ArrayList<Integer>();
        counts.addAll(map.values());
        Collections.sort(counts, Collections.reverseOrder());

        int min = counts.get(k - 1);

        List<Integer> ret = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= min) {
                ret.add(entry.getKey());
            }
        }

        int[] array = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            array[i] = ret.get(i);
        }
        return array;
    }
}
