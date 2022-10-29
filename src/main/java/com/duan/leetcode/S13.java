package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S13 {
    static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i == (s.length() - 1)) {
                sum += map.get(s.substring(i));
                continue;
            }
            String bs = s.substring(i, i + 2);
            if(map.containsKey(bs)) {
                sum += map.get(bs);
                i++;
            } else {
                sum += map.get(s.substring(i, i + 1));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        S13 s = new S13();
        System.out.println(s.romanToInt("I") + " = " + 1);
        System.out.println(s.romanToInt("III") + " = " + 3);
        System.out.println(s.romanToInt("IV") + " = " + 4);
        System.out.println(s.romanToInt("IX") + " = " + 9);
        System.out.println(s.romanToInt("LVIII") + " = " + 58);
        System.out.println(s.romanToInt("MCMXCIV") + " = " + 1994);
    }
}
