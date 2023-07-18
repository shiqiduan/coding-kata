package com.coding.one;

public class M130 {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                track(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                track(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                track(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                track(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                    System.out.println("0");
                }
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void track(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = '1';

        track(board, x + 1, y);
        track(board, x - 1, y);
        track(board, x, y + 1);
        track(board, x, y - 1);
    }
}
