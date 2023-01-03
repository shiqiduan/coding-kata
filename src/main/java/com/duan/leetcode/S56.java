package com.duan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        List<int[]> mergedList = new ArrayList<>();
        int end = intervals[0][1];
        mergedList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];

            if(x > end) {
                mergedList.add(new int[] {x, y});
                end = y;
            } else if (y > end){
                end = y;
                mergedList.get(mergedList.size() - 1)[1] = y;
            }
        }
        return mergedList.toArray(new int[][] {});
    }
}
