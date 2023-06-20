package com.coding.two.heap;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 2023-05-18 09:58:28
 */
public class M215 {
    private Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int s = 0, e = nums.length - 1;
        k = nums.length - k;
        while (true) {
            int q = quickSelect(nums, s, e);
            if (q == k) {
                return nums[q];
            } else if (q > k) {
                e = q - 1;
            } else {
                s = q + 1;
            }
        }
    }

    private int quickSelect(int[] nums, int s, int e) {
        int r = random.nextInt(e - s + 1) + s;
        int temp = nums[r];
        nums[r] = nums[e];
        nums[e] = temp;

        int x = nums[e], index = s - 1;
        for (int i = s; i <= e; i++) {
            if (nums[i] <= x) {
                index++;
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        return index;
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        M215 m = new M215();
        System.out.println(m.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(m.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
