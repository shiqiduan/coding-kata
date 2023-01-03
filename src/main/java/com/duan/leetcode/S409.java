package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer t = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), t+1);
        }
        int maxOddLen = 0;
        Character maxOdd = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer t = entry.getValue();
            if(t % 2 == 1 && t > maxOddLen) {
                maxOddLen = t;
                maxOdd = entry.getKey();
            }
        }

        int ret = maxOddLen;
        if(maxOddLen != 0) {
            map.remove(maxOdd);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer t = entry.getValue();
            if(t % 2 == 1 && (t - 1) > 0) {
                ret += t - 1;
                continue;
            }
            if(t % 2 == 0) {
                ret += t;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        S409 s = new S409();
        System.out.println(s.longestPalindrome("abccccdd"));
    }
}
