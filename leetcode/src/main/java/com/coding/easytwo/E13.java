package com.coding.easytwo;

import java.util.HashMap;
import java.util.Map;

public class E13 {
    private final Map<Character, Integer> map = new HashMap<Character, Integer>();

    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int ret = 0;
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            char current = s.charAt(i);
            if (i >= 1) {
                char prev = s.charAt(i - 1);
                if (current == 'V' && prev == 'I') {
                    ret += 4;
                    i--;
                    continue;
                } else if (current == 'X' && prev == 'I') {
                    ret += 9;
                    i--;
                    continue;
                } else if (current == 'L' && prev == 'X') {
                    ret += 40;
                    i--;
                    continue;
                } else if (current == 'C' && prev == 'X') {
                    ret += 90;
                    i--;
                    continue;
                } else if (current == 'D' && prev == 'C') {
                    ret += 400;
                    i--;
                    continue;
                } else if (current == 'M' && prev == 'C') {
                    ret += 900;
                    i--;
                    continue;
                }
            }
            ret += map.get(current);
        }
        return ret;
    }
}
