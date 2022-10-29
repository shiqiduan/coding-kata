package com.duan.leetcode;

public class S200 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    ret++;
                    bfs(grid, i, j);
                }
            }
        }
        return ret;
    }

    private void bfs(char[][] grid, int x, int y) {
        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0) {
            return;
        }
        if(grid[x][y] == '0' || grid[x][y] == '2') return;
        grid[x][y] = '2';
        bfs(grid, x + 1, y);
        bfs(grid, x - 1, y);
        bfs(grid, x, y + 1);
        bfs(grid, x, y - 1);
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
