package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class M54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startX = 0, endX = matrix.length - 1;
        int startY = 0, endY = matrix[0].length - 1;
        List<Integer> ret = new ArrayList<>();
        while (true) {
            List<Integer> track = track(matrix, startX, endX, startY, endY);
            if(track.isEmpty()) {
                return ret;
            } else {
                System.out.println(track);
                ret.addAll(track);
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
    }

    private List<Integer> track(int[][] matrix, int startX, int endX, int startY, int endY) {
        List<Integer> ret = new ArrayList<>();
        if(!(startX <= endX && startY <= endY)) {
            return ret;
        }
        for (int i = startY; i <= endY; i++) {
            ret.add(matrix[startX][i]);
        }
        for (int i = startX + 1; i < endX; i++) {
            ret.add(matrix[i][endY]);
        }
        for (int i = endY; i >= startY && startX != endX; i--) {
            ret.add(matrix[endX][i]);
        }
        for (int i = endX - 1; i > startX && startY != endY; i--) {
            ret.add(matrix[i][startY]);
        }
        return ret;
    }
}
