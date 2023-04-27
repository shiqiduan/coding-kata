package com.coding;

import java.util.HashMap;
import java.util.Map;

public class E1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // test twoSum method
    public void testTwoSum1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public void testTwoSum2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static void main(String[] args) {
        E1 a = new E1();
        a.testTwoSum1();
        a.testTwoSum2();
    }
}
