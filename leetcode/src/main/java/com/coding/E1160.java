package com.coding;

import java.util.HashMap;
import java.util.Map;

public class E1160 {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            boolean found = true;

            Map<Character, Integer> wmap = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                wmap.put(c, wmap.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : wmap.entrySet()) {
                char c = entry.getKey();
                if (map.getOrDefault(c, 0) < entry.getValue()) {
                    found = false;
                    break;
                }
            }
            ret += (found) ? words[i].length() : 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        E1160 e = new E1160();
        e.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach");
    }
}
