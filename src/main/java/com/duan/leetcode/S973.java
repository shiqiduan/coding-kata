package com.duan.leetcode;

import java.util.*;

public class S973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Double v1 = Math.pow(o1[0], 2) + Math.pow(o1[1], 2);
                Double v2 = Math.pow(o2[0], 2) + Math.pow(o2[1], 2);
                return v1.compareTo(v2);
            }
        });

        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list.toArray(new int[][]{});
    }
}
