package com.coding.one;

import java.util.ArrayList;
import java.util.List;

public class M57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

        List<int[]> list = new ArrayList<>();
        int sn = newInterval[0], en = newInterval[1];
        boolean done = false;
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (e < newInterval[0]) {
                list.add(intervals[i]);
                continue;
            }
            if (s > newInterval[1]) {
                if (!done) {
                    list.add(new int[]{sn, en});
                    done = true;
                }
                list.add(intervals[i]);
                continue;
            }
            if (s < sn) {
                sn = s;
            }
            if (e > en) {
                en = e;
            }
        }
        if (!done) {
            list.add(new int[]{sn, en});
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
