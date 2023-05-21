package com.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M17 {
    private final Map<Integer, String> map = new HashMap<Integer, String>();

    {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> prev = new ArrayList<String>();
        List<String> current = new ArrayList<String>();

        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String str = map.get(Character.getNumericValue(c));
            for (int j = 0; j < str.length(); j++) {
                char a = str.charAt(j);
                if (prev.isEmpty()) {
                    current.add(String.valueOf(a));
                } else {
                    for (int k = 0; k < prev.size(); k++) {
                        current.add(prev.get(k) + a);
                    }
                }
            }
            prev = current;
            current = new ArrayList<>();
        }
        return prev;
    }
}
