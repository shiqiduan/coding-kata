package com.coding.one;

import java.util.PriorityQueue;

public class E1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            queue.add(new int[]{i, count});
        }
        int[] ans = new int[k];
        int i = 0;
        while (i < k) {
            ans[i] = queue.poll()[0];
            i++;
        }
        return ans;
    }
}
