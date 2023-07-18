package com.coding.two;

import java.util.ArrayList;
import java.util.List;

public class M994 {
    public int orangesRotting(int[][] grid) {
        List<int[]> list = new ArrayList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (list.isEmpty()) {
            return -1;
        }
        int ans = 0;
        while (!list.isEmpty()) {
            List<int[]> newList = new ArrayList<>();
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                int[] temp = list.get(i);
                int x = temp[0], y = temp[1];
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    newList.add(new int[]{x - 1, y});
                    flag = true;
                    fresh--;
                }
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    newList.add(new int[]{x + 1, y});
                    flag = true;
                    fresh--;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    newList.add(new int[]{x, y - 1});
                    flag = true;
                    fresh--;
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    newList.add(new int[]{x, y + 1});
                    flag = true;
                    fresh--;
                }
            }
            list = newList;
            if (flag) {
                ans++;
            }
        }
        if (fresh == 0) {
            return ans;
        } else {
            return -1;
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
