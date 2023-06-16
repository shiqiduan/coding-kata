package com.coding.one;

import java.util.PriorityQueue;

public class E703 {

}

class KthLargest {
    private PriorityQueue<Integer> queue;
    private int size;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.size = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > this.size) {
            queue.poll();
        }
        return queue.peek();
    }
}