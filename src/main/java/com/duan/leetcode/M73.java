package com.duan.leetcode;

import java.util.HashSet;
import java.util.Set;

public class M73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> xset = new HashSet<>();
        Set<Integer> yset = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    xset.add(i);
                    yset.add(j);
                }
            }
        }

        for (int x : xset) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[x][j] = 0;
            }
        }

        for (int y : yset) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        M73 m = new M73();
    }
}
