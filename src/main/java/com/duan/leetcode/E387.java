package com.duan.leetcode;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index == null) {
                map.put(c, i);
            } else {
                map.put(c, -1);
            }
        }
        int minIndex = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 0) {
                minIndex = Math.min(minIndex, entry.getValue());
            }
        }
        return (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
    }
}
