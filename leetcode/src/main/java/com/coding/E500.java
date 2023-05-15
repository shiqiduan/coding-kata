package com.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E500 {
    private Map<Character, Integer> map = new HashMap<Character, Integer>();

    {
        List<String> list = new ArrayList<>();
        list.add("qwertyuiop");
        list.add("asdfghjkl");
        list.add("zxcvbnm");

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                map.put(list.get(i).charAt(j), i);
            }
        }
    }

    public String[] findWords(String[] words) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int line = map.get(Character.toLowerCase(words[i].charAt(0)));
            boolean found = true;
            for (int j = 1; j < words[i].length(); j++) {
                if (line != map.get(Character.toLowerCase(words[i].charAt(j)))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                ret.add(words[i]);
            }
        }
        return ret.toArray(new String[]{});
    }
}
