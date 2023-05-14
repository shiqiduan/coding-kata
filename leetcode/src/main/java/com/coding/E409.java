package com.coding;

import java.util.HashMap;
import java.util.Map;

public class E409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        int ret = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            ret += count / 2 * 2;
            if (count % 2 == 1 && ret % 2 == 0) {
                ret++;
            }
        }
        return ret;
    }
}
