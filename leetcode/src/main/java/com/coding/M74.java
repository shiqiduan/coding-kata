package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int xlen = matrix.length, ylen = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[xlen - 1][ylen - 1]) {
            return false;
        }

        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < xlen; i++) {
            array.add(matrix[i][0]);
        }
        int i = binarySearch(array, target);
        if (matrix[i][0] == target) {
            return true;
        }
        array = new ArrayList<>();
        for (int j = 0; j < ylen; j++) {
            array.add(matrix[i][j]);
        }
        int j = binarySearch(array, target);
        return matrix[i][j] == target;
    }

    private int binarySearch(List<Integer> array, int target) {
        int x = 0, y = array.size() - 1;
        while (x <= y) {
            int mid = x + (y - x) / 2;
            if (array.get(mid) == target) {
                return mid;
            } else if (array.get(mid) > target) {
                y = mid - 1;
            } else {
                x = mid + 1;
            }
        }
        return y;
    }
}
