package com.coding;

import java.util.HashMap;
import java.util.Map;

public class M621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int max = 0;
        int size = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                size = 0;
            }
            if (entry.getValue() == max) {
                size++;
            }
        }

        return Math.max((max - 1) * (n + 1) + size, tasks.length);
    }

    public static void main(String[] args) {
        M621 m = new M621();
        System.out.println(m.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'c', 'c', 'D', 'D', 'D', 'D'}, 2));
    }
}
