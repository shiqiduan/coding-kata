package com.coding.three;

import java.util.HashMap;
import java.util.Map;

public class E1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalStateException();
    }
}
