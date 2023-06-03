package com.coding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M316 {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }
            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1)
                    && map.getOrDefault(sb.charAt(sb.length() - 1), 0) >= 1) {
                set.remove(sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            set.add(c);
            map.put(c, map.get(c) - 1);
        }
        return sb.toString();
    }
}
