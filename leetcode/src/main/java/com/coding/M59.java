package com.coding;

public class M59 {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        generate(m, 0, n - 1, 0);
        return m;
    }

    private void generate(int[][] m, int x, int y, int num) {
        if (x > y) {
            return;
        }
        if (x == y) {
            m[x][x] = ++num;
            return;
        }

        for (int i = x; i <= y; i++) {
            m[x][i] = ++num;
        }

        for (int i = x + 1; i <= y - 1; i++) {
            m[i][y] = ++num;
        }

        for (int i = y; i >= x; i--) {
            m[y][i] = ++num;
        }

        for (int i = y - 1; i >= x + 1; i--) {
            m[i][x] = ++num;
        }

        generate(m, x + 1, y - 1, num);
    }
}
