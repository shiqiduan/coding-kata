package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Integer t = map.getOrDefault(magazine.charAt(i), 0);
            map.put(magazine.charAt(i), t + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Integer t = map.getOrDefault(ransomNote.charAt(i), 0);
            if(t <= 0) {
                return false;
            }
            map.put(ransomNote.charAt(i), t - 1);
        }
        return true;
    }
}
