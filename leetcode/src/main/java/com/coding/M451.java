package com.coding;

import java.util.*;

public class M451 {
    public String frequencySort(String s) {
        Map<Character, Integer> cmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cmap.put(c, cmap.getOrDefault(c, 0) + 1);
        }
        Map<Integer, List<Character>> countMap = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> entry : cmap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            List<Character> list = countMap.getOrDefault(value, new ArrayList<>());
            list.add(key);
            countMap.put(value, list);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<Character>> entry : countMap.entrySet()) {
            int count = entry.getKey();
            for (Character c : entry.getValue()) {
                for (int i = 0; i < count; i++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
