package com.duan.leetcode;

public class S200 {
    public int numIslands(char[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    ret++;
                    track(grid, i, j);
                }
            }
        }
        return ret;
    }

    private void track(char[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if(grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '2';

        track(grid, x - 1, y);
        track(grid, x + 1, y);
        track(grid, x, y - 1);
        track(grid, x, y + 1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };

        S200 s = new S200();
        System.out.println(s.numIslands(grid));
    }
}
