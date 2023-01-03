package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S994 {
    public int orangesRotting(int[][] grid) {
        List<int[]> queue = new ArrayList<>();
        int freshCount = 0;
        int step = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int v = grid[i][j];
                if(v == 2) {
                    queue.add(new int[]{i, j});
                } else if (v == 1) {
                    freshCount++;
                }
            }
        }
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            List<int[]> newQueue = new ArrayList<>();
            boolean flag = false;
            for (int i = 0; i < queue.size(); i++) {
                int[] p = queue.get(i);
                int x = p[0], y = p[1];
                for (int j = 0; j < 4; j++) {
                    if((x + dx[j]) >= 0 && (x + dx[j]) < grid.length
                       && (y + dy[j]) >= 0 && (y + dy[j]) < grid[0].length) {
                        if(grid[x + dx[j]][y + dy[j]] == 1) {
                            newQueue.add(new int[] {x + dx[j], y + dy[j]});
                            grid[x + dx[j]][y + dy[j]] = 2;
                            freshCount--;
                            System.out.println(step + " " + (x + dx[j]) + " = " + (y + dy[j]));
                            flag = true;
                        }
                    }
                }
            }
            queue = newQueue;
            if(flag) {
                step++;
            }
        }

        if(freshCount != 0) return -1;
        return step;
    }
}
