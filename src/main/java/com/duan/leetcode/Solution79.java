package com.duan.leetcode;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if (m * n < word.length()) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTrack(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(int x, int y, int num, char[][] board, String word) {
        // 不在边界内
        if (!(x >= 0 && x < board.length && y >= 0 && y < board[0].length)) return false;
        if (board[x][y] != word.charAt(num)) {
            return false;
        }

        if (num == (word.length() - 1)) {
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '.';
        boolean b = backTrack(x + 1, y, num + 1, board, word) || backTrack(x, y + 1, num + 1, board, word)
                || backTrack(x - 1, y, num + 1, board, word) || backTrack(x, y - 1, num + 1, board, word);
        board[x][y] = temp;
        return b;
    }

    public static void main(String[] args) {
        Solution79 s = new Solution79();
        char[][] b = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        s.exist(b, word);
    }
}
