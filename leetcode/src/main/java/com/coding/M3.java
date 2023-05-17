package com.coding;

import java.util.HashMap;
import java.util.Map;

/**
 * 双指针、map
 */
public class M3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int a = 0, b = 0, ret = 0;
        boolean bf = true;
        while (b <= (s.length() - 1)) {
            if (bf) {
                char c = s.charAt(b);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == 2) {
                    bf = false;
                }
                ret = Math.max(ret, map.size());
                b++;
            } else {
                char c = s.charAt(a);
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == 1) {
                    bf = true;
                } else {
                    map.remove(c);
                }
                a++;
            }
        }
        return ret;
    }
}
