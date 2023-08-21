package com.coding.two;

import java.util.ArrayList;
import java.util.List;

public class M57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> ret = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];
        boolean done = false;
        for (int[] x : intervals) {
            if (x[0] < newInterval[0] && x[1] < newInterval[0]) {
                ret.add(x);
                continue;
            }
            if (x[0] > newInterval[1]) {
                if (!done) {
                    ret.add(new int[]{start, end});
                    done = true;
                }
                ret.add(x);
                continue;
            }

            if (x[0] < start) {
                start = x[0];
            }
            if (x[1] > end) {
                end = x[1];
            }
        }
        if (!done) {
            ret.add(new int[]{start, end});
        }

        return ret.toArray(new int[ret.size()][2]);
    }
}
