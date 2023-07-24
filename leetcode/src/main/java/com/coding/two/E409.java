package com.coding.two;

import java.util.HashMap;
import java.util.Map;

public class E409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int c = entry.getValue();
            if (c % 2 == 0) {
                ans += c;
            } else {
                ans += c - 1;
                flag = true;
            }
        }
        return (flag) ? ans + 1 : ans;
    }
}
