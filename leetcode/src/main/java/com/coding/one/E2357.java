package com.coding.one;

import java.util.PriorityQueue;

public class E2357 {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                queue.add(nums[i]);
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            PriorityQueue<Integer> newQueue = new PriorityQueue<>();
            int size = queue.size();
            int first = queue.poll();
            for (int i = 1; i < size; i++) {
                int x = queue.poll() - first;
                if (x != 0) {
                    newQueue.add(x);
                }
            }
            queue = newQueue;
            ans++;
        }
        return ans;
    }
}
