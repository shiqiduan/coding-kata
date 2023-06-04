package com.coding;

import java.util.HashMap;
import java.util.Map;

public class M1302 {
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int level = dfs(root, 0, map);
        return map.get(level);
    }

    private int dfs(TreeNode node, int level, Map<Integer, Integer> map) {
        if (node == null) {
            return level - 1;
        }
        map.put(level, map.getOrDefault(level, 0) + node.val);
        return Math.max(dfs(node.left, level + 1, map),
                dfs(node.right, level + 1, map));
    }
}
