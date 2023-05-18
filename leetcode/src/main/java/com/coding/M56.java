package com.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<int[]>();

        int a = intervals[0][0], b = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int x = intervals[i][0], y = intervals[i][1];
            if (x > b) {
                list.add(new int[]{a, b});
                a = x;
                b = y;
            } else {
                if (y > b) {
                    b = y;
                }
            }
        }
        list.add(new int[]{a, b});

        int[][] ret = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
