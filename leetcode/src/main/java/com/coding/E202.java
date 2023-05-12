package com.coding;

import java.util.HashMap;
import java.util.Map;

public class E202 {
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (true) {
            if (map.containsKey(n)) {
                return false;
            }
            String ns = n + "";
            int x = 0;
            for (int i = 0; i < ns.length(); i++) {
                int t = Character.getNumericValue(ns.codePointAt(i));
                x += t * t;
            }
            if (x == 1) {
                return true;
            } else {
                map.put(n, x);
            }
            n = x;
        }
    }

    public static void main(String[] args) {
        E202 e = new E202();

        System.out.println(e.isHappy(2));
    }
}
