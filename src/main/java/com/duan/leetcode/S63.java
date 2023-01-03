package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Map<String, Integer> map = new HashMap<>();
        return track(obstacleGrid, 0, 0, map);
    }

    private int track(int[][] grid, int x, int y, Map<String, Integer> map) {
        String key = x + "=" + y;
        if(map.containsKey(key)) {
            System.out.println(key);
            return map.get(key);
        }
        if(x >= grid.length) {
            map.put(key, 0);
            return 0;
        }
        if(y >= grid[0].length) {
            map.put(key, 0);
            return 0;
        }
        if(grid[x][y] == 1) {
            map.put(key, 0);
            return 0;
        }
        if(x == grid.length - 1 && y == grid[0].length - 1) {
            map.put(key, 1);
            return 1;
        }
        return track(grid, x + 1, y, map) + track(grid, x, y + 1, map);
    }
}
