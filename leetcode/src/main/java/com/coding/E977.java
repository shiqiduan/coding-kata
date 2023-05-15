package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E977 {
    public int[] sortedSquares(int[] nums) {
        int x = -1, y = nums.length;
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                x = i;
            } else if (nums[i] == 0) {
                ret.add(0);
            } else {
                if (y == nums.length) {
                    y = i;
                }
            }
        }
        while (x >= 0 || y < nums.length) {
            int rx = (x >= 0) ? nums[x] * nums[x] : Integer.MAX_VALUE;
            int ry = (y < nums.length) ? nums[y] * nums[y] : Integer.MAX_VALUE;
            if (rx < ry) {
                ret.add(rx);
                x--;
            } else if (rx > ry) {
                ret.add(ry);
                y++;
            } else {
                ret.add(rx);
                ret.add(ry);
                x--;
                y++;
            }
        }

        int[] array = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            array[i] = ret.get(i);
        }
        return array;
    }
}
