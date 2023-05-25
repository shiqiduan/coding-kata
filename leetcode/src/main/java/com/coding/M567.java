package com.coding;

import java.util.HashMap;
import java.util.Map;

public class M567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int s = 0;
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!map1.containsKey(c)) {
                map2 = new HashMap<>();
                s = i + 1;
                continue;
            }

            map2.put(c, map2.getOrDefault(c, 0) + 1);

            while (map2.get(c) > map1.get(c)) {
                char c1 = s2.charAt(s);
                int t = map2.get(c1);
                if (t == 1) {
                    map2.remove(c1);
                } else {
                    map2.put(c1, t - 1);
                }
                s++;
            }

            if (map1.equals(map2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        M567 m = new M567();

        System.out.println(m.checkInclusion("adc", "dcda"));
        System.out.println(m.checkInclusion("ab", "eidbaooo"));
        System.out.println(m.checkInclusion("ab", "eidboaooo"));
    }
}
