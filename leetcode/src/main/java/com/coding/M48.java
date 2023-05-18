package com.coding;

public class M48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int a = 0, b = n - 1;
        while (a < b) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][a];
                matrix[i][a] = matrix[i][b];
                matrix[i][b] = temp;
            }
            a++;
            b--;
        }
    }
}
