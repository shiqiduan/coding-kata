package com.coding;

public class M200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    track(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void track(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        track(grid, i + 1, j);
        track(grid, i - 1, j);
        track(grid, i, j + 1);
        track(grid, i, j - 1);
    }
}
