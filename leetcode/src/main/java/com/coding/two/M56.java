package com.coding.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ret = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (ret.size() == 0 || ret.get(ret.size() - 1)[1] < l) {
                ret.add(new int[]{l, r});
            } else {
                ret.get(ret.size() - 1)[1] = Math.max(ret.get(ret.size() - 1)[1], r);
            }
        }
        return ret.toArray(new int[1][1]);
    }

    public static void main(String[] args) {

    }
}
