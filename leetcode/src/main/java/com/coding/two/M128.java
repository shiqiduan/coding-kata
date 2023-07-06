package com.coding.two;

import java.util.HashSet;
import java.util.Set;

public class M128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!set.contains(x)) {
                continue;
            }
            int len = 1;
            set.remove(x);
            int temp = 1;
            while (set.contains(x + temp)) {
                set.remove(x + temp);
                len++;
                temp++;
            }
            temp = 1;
            while (set.contains(x - temp)) {
                set.remove(x - temp);
                len++;
                temp++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
