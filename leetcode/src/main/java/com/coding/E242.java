package com.coding;

import java.util.HashMap;
import java.util.Map;

public class E242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = countMap.getOrDefault(c, 0);
            countMap.put(c, count + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!countMap.containsKey(c)) {
                return false;
            }
            Integer count = countMap.get(c);
            if (count == 1) {
                countMap.remove(c);
            } else {
                countMap.put(c, count - 1);
            }
        }
        return countMap.isEmpty();
    }
}
