package com.coding;

import java.util.TreeSet;

public class E414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return (set.size() == 3) ? set.first() : set.last();
    }
}
