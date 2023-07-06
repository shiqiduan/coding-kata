package com.coding.two;

public class M36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] matrix = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int m = i / 3 * 3 + j / 3;

                    if (row[i][num] || column[j][num] || matrix[m][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    column[j][num] = true;
                    matrix[m][num] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('5' - '0');
    }
}
