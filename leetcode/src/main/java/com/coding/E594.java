package com.coding;

import java.util.HashMap;
import java.util.Map;

public class E594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ret = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (map.containsKey(key - 1)) {
                ret = Math.max(ret, map.get(key - 1) + map.get(key));
            }
            if (map.containsKey(key + 1)) {
                ret = Math.max(ret, map.get(key + 1) + map.get(key));
            }
        }
        return (ret == 1) ? 0 : ret;
    }
}
