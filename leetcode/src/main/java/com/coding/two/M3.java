package com.coding.two;

import java.util.HashSet;
import java.util.Set;

/**
 * 双指针、map
 */
public class M3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int ans = 0, a = 0, b = 0;
        while (b < s.length()) {
            char c = s.charAt(b);
            if (!set.contains(c)) {
                set.add(c);
                b++;
            } else {
                set.remove(s.charAt(a));
                a++;
            }
            ans = Math.max(ans, b - a);
        }
        return ans;
    }
}
