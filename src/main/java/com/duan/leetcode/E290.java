package com.duan.leetcode;

import java.util.*;

public class E290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        Map<Integer, String> sMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            sMap.put(i, s1[i]);
            set.add(s1[i]);
        }

        if(pattern.length() != s1.length) {
            return false;
        }

        if (set.size() != map.size()) {
            return false;
        }

        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            String first = sMap.get(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                if (!first.equals(sMap.get(list.get(i)))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        E290 e = new E290();

        System.out.println(e.wordPattern("abba", "dog cat cat dog"));
    }
}
