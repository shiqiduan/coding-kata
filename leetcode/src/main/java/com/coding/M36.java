package com.coding;

public class M36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[board.length][board.length];
        boolean[][] colums = new boolean[board.length][board.length];
        boolean[][][] matrix = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                boolean digit = Character.isDigit(board[i][j]);
                if (!digit) {
                    continue;
                }
                int num = Character.getNumericValue(board[i][j]) - 1;

                if (rows[i][num]) {
                    return false;
                } else {
                    rows[i][num] = true;
                }

                if (colums[j][num]) {
                    return false;
                } else {
                    colums[j][num] = true;
                }
                if (matrix[i / 3][j / 3][num]) {
                    return false;
                } else {
                    matrix[i / 3][j / 3][num] = true;
                }
            }
        }
        return true;
    }
}
