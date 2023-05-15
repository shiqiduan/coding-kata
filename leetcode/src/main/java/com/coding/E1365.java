package com.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < temp.length; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], i);
            }
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = map.get(nums[i]);
        }
        return ret;
    }
}
