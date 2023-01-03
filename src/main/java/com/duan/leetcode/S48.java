package com.duan.leetcode;

public class S48 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                swap(matrix, j, i, matrix[0].length - j - 1, i);
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, j, i, i, j);
            }
        }
    }

    private void swap(int[][] matrix, int x, int y, int a, int b) {
        int temp = matrix[x][y];
        matrix[x][y] = matrix[a][b];
        matrix[a][b] = temp;
    }
}
