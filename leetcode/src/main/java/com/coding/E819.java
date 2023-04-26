package com.coding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            bannedSet.add(banned[i]);
        }

        paragraph = paragraph.replace('!', ' ').replace('?', ' ').replace('\'', ' ').replace(',', ' ').replace(';', ' ').replace('.', ' ').trim();

        String[] split = paragraph.split("\\s+");

        Map<String, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        String ret = "";

        for (int i = 0; i < split.length; i++) {
            String s = split[i].toLowerCase();
            if (bannedSet.contains(s) || s.length() == 0) {
                continue;
            }
            int count = countMap.getOrDefault(s, 0) + 1;
            countMap.put(split[i], count);

            if (count > maxCount) {
                ret = s;
                maxCount = count;
            }
        }
        return ret;
    }

    // test
    public static void main(String[] args) {
        E819 e = new E819();
        System.out.println(e.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
