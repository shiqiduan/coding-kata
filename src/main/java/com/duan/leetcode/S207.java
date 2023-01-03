package com.duan.leetcode;

import java.util.*;

public class S207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][0];
            int val = prerequisites[i][1];

            Set<Integer> set = map.getOrDefault(key, new HashSet<>());
            set.add(val);
            map.put(key, set);
        }

        for (int i = 0; i < numCourses - 1; i++) {
            Set<Integer> set = new HashSet<>();
            boolean track = track(map, i, set);
            if(!track) {
                return false;
            } else {
                map.remove(i);
            }
        }
        return true;
    }

    private boolean track(Map<Integer, Set<Integer>> map, int x, Set<Integer> set) {
        if(!map.containsKey(x) || map.get(x).isEmpty()) {
            return true;
        }
        if(set.contains(x)) return false;

        set.add(x);
        for(Integer s : map.get(x)) {
            boolean track = track(map, s, set);
            if(!track) {
                return false;
            }
        }
        set.remove(x);
        return true;
    }
}
