package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class H76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // 统计数量
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int minLen = s.length() + 1;
        String ret = "";
        int count = 0, start = 0;
        boolean moveLeft = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!countMap.containsKey(c)) {
                continue;
            }
            countMap.put(c, countMap.get(c) - 1);
            if (countMap.get(c) == 0) {
                count++;
            }
            if (count == countMap.size()) {
                if((i - start + 1) < minLen) {
                    minLen = i - start + 1;
                    ret = s.substring(start, i + 1);
                }
                moveLeft = true;
            }

            while (moveLeft && (start < i)) {
                while (!countMap.containsKey(s.charAt(start)) && start < i) {
                    start++;
                }
                char removed = s.charAt(start);
                if((i - start + 1) < minLen) {
                    minLen = i - start + 1;
                    ret = s.substring(start, i + 1);
                }
                do {
                    start++;
                } while (start < i && !countMap.containsKey(s.charAt(start)));

                if(countMap.get(removed) == 0) {
                    count--;
                }
                countMap.put(removed, countMap.get(removed) + 1);
                if(count == countMap.size()) {
                    if((i - start + 1) < minLen) {
                        minLen = i - start + 1;
                        ret = s.substring(start, i + 1);
                    }
                } else {
                    moveLeft = false;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        H76 h = new H76();

        System.out.println(h.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(h.minWindow("ab", "ab"));
        System.out.println(h.minWindow("a", "a"));
        System.out.println(h.minWindow("a", "b"));
        System.out.println(h.minWindow("abbca", "abc"));
        System.out.println(h.minWindow("111a111b11b1c1a1", "abc"));
        System.out.println(h.minWindow("abbbbbbc", "bc"));
        System.out.println(h.minWindow("ab", "b"));
    }
}
