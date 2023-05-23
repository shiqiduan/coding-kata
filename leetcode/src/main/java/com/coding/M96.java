package com.coding;

import java.util.HashMap;
import java.util.Map;

public class M96 {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        map.put(2, 2);
        return numTrees(n, map);
    }

    private int numTrees(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += numTrees(i - 1, map) * numTrees(n - i, map);
        }
        map.put(n, ans);
        return ans;
    }
}
