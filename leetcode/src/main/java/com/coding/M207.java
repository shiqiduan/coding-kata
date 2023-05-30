package com.coding;

import java.util.*;

public class M207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Integer> inNumMap = new HashMap<>();
        Map<Integer, Set<Integer>> outMap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int[] x = prerequisites[i];
            Set<Integer> set = outMap.getOrDefault(x[0], new HashSet<>());
            set.add(x[1]);
            outMap.put(x[0], set);

            inNumMap.put(x[1], inNumMap.getOrDefault(x[1], 0) + 1);
            inNumMap.put(x[0], inNumMap.getOrDefault(x[0], 0));
        }

        while (!inNumMap.isEmpty()) {
            List<Integer> inNumZero = new ArrayList<>();

            for (Iterator<Map.Entry<Integer, Integer>> it = inNumMap.entrySet().iterator();
                 it.hasNext(); ) {
                Map.Entry<Integer, Integer> next = it.next();
                if (next.getValue() <= 0) {
                    inNumZero.add(next.getKey());
                    it.remove();
                }
            }
            if (inNumMap.isEmpty()) return true;
            if (inNumZero.size() == 0) return false;

            for (int i = 0; i < inNumZero.size(); i++) {
                int k = inNumZero.get(i);

                if (!outMap.containsKey(k)) continue;

                for (Integer x : outMap.get(k)) {
                    if (inNumMap.containsKey(x)) {
                        inNumMap.put(x, inNumMap.get(x) - 1);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        M207 m = new M207();

        int[][] arr = new int[][]{
                {1, 0}, {0, 1}
        };

        System.out.println(m.canFinish(2, arr));
    }
}
