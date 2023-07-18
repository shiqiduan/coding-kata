package com.coding.one;

import java.util.Map;
import java.util.TreeMap;

public class M853 {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        Double t = null;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.descendingMap().entrySet()) {
            Integer pos = entry.getKey();
            Integer spd = entry.getValue();
            double temp = (target * 1.0 - pos) / spd;
            if (t == null) {
                t = temp;
                ans = 1;
            } else {
                if (temp > t) {
                    ans++;
                    t = temp;
                }
            }
        }
        return ans;
    }
}
