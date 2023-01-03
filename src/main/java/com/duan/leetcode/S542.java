package com.duan.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class S542 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] != 0) {
                    mat[i][j] = -1;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length
                    && mat[newX][newY] == -1) {
                    mat[newX][newY] = mat[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        return mat;
    }


    public static void main(String[] args) {
        S542 s = new S542();
        int[][] mat = new int[][] {
                {0,1,0},
                {0,1,0},
                {0,1,0},
                {0,1,0},
                {0,1,0},
        };

        System.out.println(s.updateMatrix(mat));
    }
}
