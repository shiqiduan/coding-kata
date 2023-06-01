package com.coding;

public class M289 {
    private int[][] adds = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1},
    };

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = count(board, i, j);
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = -1;
                    continue;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int count(int[][] board, int x, int y) {
        int ret = 0;
        for (int[] temp : adds) {
            if ((x + temp[0]) >= 0 && (x + temp[0]) < board.length
                    && (y + temp[1]) >= 0 && (y + temp[1]) < board[0].length) {
                if (board[x + temp[0]][y + temp[1]] == 1
                        || board[x + temp[0]][y + temp[1]] == -1) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
