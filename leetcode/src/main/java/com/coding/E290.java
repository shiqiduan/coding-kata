package com.coding;

import java.util.HashMap;
import java.util.Map;

public class E290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap<Character, String>();
        Map<String, Character> s2p = new HashMap<String, Character>();
        String[] s1 = s.split(" ");

        if (pattern.length() != s1.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char x = pattern.charAt(i);
            String y = s1[i];
            if (p2s.containsKey(x) && !p2s.get(x).equals(y) ||
                    s2p.containsKey(y) && !s2p.get(y).equals(x)) {
                return false;
            }
            p2s.put(pattern.charAt(i), s1[i]);
            s2p.put(s1[i], pattern.charAt(i));
        }
        return true;
    }

}
