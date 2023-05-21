package com.coding;

import java.util.HashMap;
import java.util.Map;

public class E697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        for (int i = 0; i < nums.length; i++) {
            int[] array = map.getOrDefault(nums[i], new int[3]);
            if (array[0] == 0) {
                array[1] = i;
            }
            array[2] = i;
            array[0] = array[0] + 1;
            map.put(nums[i], array);
        }
        int max = 0, min = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] array = entry.getValue();
            if (array[0] > max) {
                max = array[0];
                min = array[2] - array[1] + 1;
            } else if (array[0] == max) {
                int temp = array[2] - array[1] + 1;
                min = Math.min(min, array[2] - array[1] + 1);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        E697 e = new E697();
        System.out.println(e.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
