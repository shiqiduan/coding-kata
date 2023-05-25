package com.coding;

import java.util.HashSet;
import java.util.Set;

public class M128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!set.contains(x)) continue;

            int a = x + 1;
            int len = 1;
            while (set.contains(a)) {
                len++;
                set.remove(a);
                a++;
            }
            int b = x - 1;
            while (set.contains(b)) {
                len++;
                set.remove(b);
                b--;
            }
            ret = Math.max(ret, len);
        }
        return ret;
    }
}
