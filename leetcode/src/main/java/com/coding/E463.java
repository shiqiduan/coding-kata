package com.coding;

public class E463 {
    public int islandPerimeter(int[][] grid) {
        int m = 0, n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                m++;

                if (i >= 1 && grid[i - 1][j] == 1) {
                    n++;
                }
                if (i <= grid.length - 2 && grid[i + 1][j] == 1) {
                    n++;
                }
                if (j >= 1 && grid[i][j - 1] == 1) {
                    n++;
                }
                if (j <= grid[0].length - 2 && grid[i][j + 1] == 1) {
                    n++;
                }
            }
        }
        return m * 4 - n;
    }
}
