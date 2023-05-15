package com.coding;

import java.util.HashSet;
import java.util.Set;

public class E771 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int ret = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                ret++;
            }
        }
        return ret;
    }
}
