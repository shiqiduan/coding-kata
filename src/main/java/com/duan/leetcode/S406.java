package com.duan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        List<int[]> ret = new ArrayList<>();
        for(int[] person: people) {
            ret.add(person[1], person);
        }
        return ret.toArray(new int[ret.size()][]);
    }
}
