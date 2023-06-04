package com.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M515 {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map);
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getKey(), entry.getValue());
        }
        return ans;
    }

    private void dfs(TreeNode node, int level, Map<Integer, Integer> map) {
        if (node == null) return;

        map.put(level, Math.max(map.getOrDefault(level, Integer.MIN_VALUE), node.val));
        dfs(node.left, level + 1, map);
        dfs(node.right, level + 1, map);
    }
}
