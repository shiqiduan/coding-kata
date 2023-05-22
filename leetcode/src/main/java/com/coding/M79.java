package com.coding;

public class M79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (track(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean track(char[][] board, int s, int e, int index, String word) {
        if (s < 0 || s >= board.length || e < 0 || e >= board[0].length) {
            return false;
        }
        if (index >= word.length()) {
            return false;
        }
        if (board[s][e] != word.charAt(index)) {
            return false;
        }

        if (board[s][e] == word.charAt(index) && index == word.length() - 1) {
            return true;
        }

        char temp = board[s][e];
        board[s][e] = '0';
        boolean ret = track(board, s + 1, e, index + 1, word)
                || track(board, s - 1, e, index + 1, word)
                || track(board, s, e + 1, index + 1, word)
                || track(board, s, e - 1, index + 1, word);
        board[s][e] = temp;
        return ret;
    }
}
