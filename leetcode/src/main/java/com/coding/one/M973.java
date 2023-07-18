package com.coding.one;

import java.util.PriorityQueue;

public class M973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> distant(o2) - distant(o1));
        for (int i = 0; i < points.length; i++) {
            heap.add(points[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (!heap.isEmpty()) {
            ans[i] = heap.poll();
            i++;
        }
        return ans;
    }

    private int distant(int[] array) {
        int x = array[0];
        int y = array[1];
        return x * x + y * y;
    }
}
