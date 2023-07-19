package com.coding.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int s = intervals[0][0], e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int sn = intervals[i][0], en = intervals[i][1];
            if (sn > e) {
                list.add(new int[]{s, e});
                s = sn;
                e = en;
            } else {
                if (en > e) {
                    e = en;
                }
            }
        }
        list.add(new int[]{s, e});
        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
