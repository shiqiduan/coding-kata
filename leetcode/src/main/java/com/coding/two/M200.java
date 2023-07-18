package com.coding.two;

public class M200 {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    track(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void track(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] != 1) {
            return;
        }
        grid[x][y] = '2';

        track(grid, x + 1, y);
        track(grid, x - 1, y);
        track(grid, x, y + 1);
        track(grid, x, y - 1);
    }
}
