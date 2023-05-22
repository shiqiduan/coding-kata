package com.coding;

public class M695 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j, 0));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int x, int y, int count) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return count;
        }
        if (grid[x][y] == 0) {
            return count;
        }
        grid[x][y] = 0;
        count++;
        count = Math.max(dfs(grid, x + 1, y, count), count);
        count = Math.max(dfs(grid, x - 1, y, count), count);
        count = Math.max(dfs(grid, x, y + 1, count), count);
        count = Math.max(dfs(grid, x, y - 1, count), count);
        return count;
    }
}
