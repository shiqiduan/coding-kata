package com.duan.leetcode;

public class E463 {
    public int islandPerimeter(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int sum = 0;

        for (int i = 0; i < x; i++) {
            if (grid[i][0] == 1) {
                sum++;
            }
            if (grid[i][y - 1] == 1) {
                sum++;
            }

            for (int j = 1; j < y; j++) {
                if (grid[i][j - 1] != grid[i][j]) {
                    sum++;
                }
            }
        }

        for (int i = 0; i < y; i++) {
            if (grid[0][i] == 1) {
                sum++;
            }
            if (grid[x - 1][i] == 1) {
                sum++;
            }

            for (int j = 1; j < x; j++) {
                if (grid[j - 1][i] != grid[j][i]) {
                    sum++;
                }
            }
        }

        return sum;
    }
}
