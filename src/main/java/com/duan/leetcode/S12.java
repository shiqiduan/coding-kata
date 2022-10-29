package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S12 {
    private Map<Integer, String> map = new HashMap<>();

    {
        map.put(1000, "M");
        map.put(500, "D");
        map.put(100, "C");
        map.put(50, "L");
        map.put(10, "X");
        map.put(5, "V");
        map.put(1, "I");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }

    private int[] cells = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            int a = num / cells[i];
            if (a == 0) continue;

            int key = a * cells[i];
            if (map.containsKey(key)) {
                ret.append(map.get(key));
            } else {
                String c = map.get(cells[i]);
                while (a > 0) {
                    ret.append(c);
                    a--;
                }
            }
            num = num % cells[i];
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        S12 s = new S12();
        System.out.println(s.intToRoman(3));
        System.out.println(s.intToRoman(4));
        System.out.println(s.intToRoman(9));
        System.out.println(s.intToRoman(58));
        System.out.println(s.intToRoman(1994));
        System.out.println(s.intToRoman(2000));
    }
}
