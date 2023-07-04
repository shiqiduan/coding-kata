package com.coding.two;

import java.util.HashMap;
import java.util.Map;

public class E242 {
    public boolean isAnagram(String s, String t) {
        return strToMap(s).equals(strToMap(t));
    }

    private Map<Character, Integer> strToMap(String str) {
        if (str == null || str.isEmpty()) {
            return new HashMap<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();

        a.put("a", 10);
        b.put("a", 10);

        System.out.println(a.equals(b));
    }
}
