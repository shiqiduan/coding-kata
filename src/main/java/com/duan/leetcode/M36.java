package com.duan.leetcode;

import java.util.Arrays;

public class M36 {
    public boolean isValidSudoku(char[][] board) {
        int[] nums = new int[10];

        int length = board.length;
        int width = board[0].length;

        for (int i = 0; i < length; i++) {
            Arrays.fill(nums, 0);
            for (int j = 0; j < width; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int x = c - 48;
                nums[x]++;
                if (nums[x] > 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < width; i++) {
            Arrays.fill(nums, 0);
            for (int j = 0; j < length; j++) {
                char c = board[j][i];
                if (c == '.') continue;
                int x = c - 48;
                nums[x]++;
                if (nums[x] > 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < length; i = i + 3) {
            for (int j = 0; j < width; j = j + 3) {
                Arrays.fill(nums, 0);
                int x = i, y = j;
                for (int k = x; k < x + 3; k++) {
                    for (int l = y; l < y + 3; l++) {
                        char c = board[k][l];
                        if (c == '.') continue;
                        int a = c - 48;
                        nums[a]++;
                        if (nums[a] > 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char c = '9';

        System.out.println(c - 49);
    }
}
