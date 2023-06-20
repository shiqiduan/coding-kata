package com.coding.two.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class M451 {
    public String frequencySort(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(charCountMap.entrySet());
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> poll = queue.poll();
            sb.append(String.valueOf(poll.getKey()).repeat(Math.max(0, poll.getValue())));
        }
        return sb.toString();
    }
}
