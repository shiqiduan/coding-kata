package com.coding;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class E219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                int b = nums[i - k - 1];
                Integer c = mapCount.getOrDefault(b, 0);
                if (c == 1) {
                    mapCount.remove(b);
                } else {
                    mapCount.put(b, c - 1);
                }
            }

            int x = nums[i];
            if (mapCount.containsKey(x)) {
                return true;
            }
            Integer c = mapCount.getOrDefault(nums[i], 0);
            mapCount.put(x, c + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        E219 e = new E219();
        System.out.println(e.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }
}
