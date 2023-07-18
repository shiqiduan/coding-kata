package com.coding.two;

import java.util.Arrays;

public class M73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        boolean fr = false, fc = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                fc = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                fr = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (fc) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (fr) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
