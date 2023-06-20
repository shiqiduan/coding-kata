package com.coding.two.heap;

import java.util.*;

public class M347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> itemCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            itemCountMap.put(nums[i], itemCountMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : itemCountMap.entrySet()) {
            heap.add(new int[]{entry.getKey(), entry.getValue()});
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] x : heap) {
            ans.add(x[0]);
        }
        return ans.stream().mapToInt(value -> value).toArray();
    }
}
