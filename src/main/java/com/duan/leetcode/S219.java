package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) return false;
        int start = 0, end = 0;
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if((end - start) <= k) {
                if(numCountMap.containsKey(key)) {
                    return true;
                } else {
                    numCountMap.put(key, numCountMap.getOrDefault(key, 0) + 1);
                }
                end++;
            } else {
                if(numCountMap.containsKey(nums[start])) {
                    Integer count = numCountMap.get(nums[start]);
                    if(count == 1) {
                        numCountMap.remove(nums[start]);
                    } else {
                        numCountMap.put(nums[start], count - 1);
                    }
                }

                start++;
                end++;

                if(numCountMap.containsKey(key)) {
                    return true;
                } else {
                    numCountMap.put(key, numCountMap.getOrDefault(key, 0));
                }
                end++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        S219 s = new S219();
        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(s.containsNearbyDuplicate(new int[]{1,0, 1,1}, 1));
        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3}, 1));
        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3}, 0));
    }
}
