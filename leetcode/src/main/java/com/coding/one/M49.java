package com.coding.one;

import java.util.*;

public class M49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String ns = new String(cs);
            List<String> list = map.getOrDefault(ns, new ArrayList<>());
            list.add(str);
            map.put(ns, list);
        }
        return new ArrayList<>(map.values());
    }
}
