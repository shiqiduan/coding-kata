package com.duan.leetcode;

public class E74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int small = matrix[0][0];
        int large = matrix[matrix.length - 1][matrix[0].length - 1];
        if (target < small || target > large) {
            return false;
        }

        int line = 0;
        int start = 0, end = matrix.length - 1;
        if (target >= matrix[end][0]) {
            line = end;
        } else {
            while (start < end) {
                int mid = start + (end - start + 1) / 2;
                int midValue = matrix[mid][0];

                if (target >= midValue) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }
            line = start;
        }

        start = 0;
        end = matrix[0].length - 1;
        while (start <= end) {
            int mid = start + (end - start + 1) / 2;
            int midValue = matrix[line][mid];

            if (midValue == target) {
                return true;
            }
            if (target > midValue) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        E74 e = new E74();
    }
}
