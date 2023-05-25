package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M994 {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        List<int[]> nodes = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    nodes.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int ret = 0;
        List<int[]> add = List.of(new int[]{1, 0},
                new int[]{-1, 0},
                new int[]{0, 1},
                new int[]{0, -1});
        while (!nodes.isEmpty()) {
            List<int[]> newNodes = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                int[] temp = nodes.get(i);
                int x = temp[0];
                int y = temp[1];
                for (int[] item : add) {
                    int a = x + item[0];
                    int b = y + item[1];

                    if (a >= 0 && a < grid.length && b >= 0 && b < grid[0].length
                            && grid[a][b] == 1) {
                        fresh--;
                        grid[a][b] = 2;
                        newNodes.add(new int[]{a, b});
                    }
                }
            }
            nodes = newNodes;
            ret++;
        }

        if (fresh > 0) {
            return -1;
        } else {
            return ret - 1;
        }
    }

    public static void main(String[] args) {
        M994 m = new M994();

        System.out.println(m.orangesRotting(new int[][]{
                {0}
        }));

        System.out.println(m.orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 1}, {0, 1, 2}
        }));

        System.out.println(m.orangesRotting(new int[][]{
                {2, 1, 1}, {0, 1, 1}, {1, 0, 1}
        }));

        System.out.println(m.orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));

        System.out.println(m.orangesRotting(new int[][]{
                {0, 2}
        }));
    }
}
