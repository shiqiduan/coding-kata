package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<int[]>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ret.add(intervals[i]);
            i++;
        }
        int left = newInterval[0];
        int right = newInterval[1];
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            left = Math.min(left, intervals[i][0]);
            right = Math.max(right, intervals[i][1]);
            i++;
        }
        ret.add(new int[] {left, right});

        while (i < intervals.length) {
            ret.add(intervals[i]);
            i++;
        }
        return ret.toArray(new int[][]{});
    }
}
