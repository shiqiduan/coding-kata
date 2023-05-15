package com.coding;

import java.util.PriorityQueue;

public class E703 {
}

class KthLargest {

    private PriorityQueue<Integer> queue;
    private int limit;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<Integer>();
        limit = k;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > limit) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > limit) {
            queue.poll();
        }
        return queue.peek();
    }
}
