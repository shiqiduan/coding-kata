package com.coding.two.dp;

import com.coding.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M337 {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        dfs(root, map);
        return map.get(root);
    }

    private int dfs(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return 0;

        if (map.containsKey(node)) {
            return map.get(node);
        }

        int m1 = dfs(node.left, map) + dfs(node.right, map);

        int m2 = node.val;
        if (node.left != null) {
            m2 += dfs(node.left.left, map) + dfs(node.left.right, map);
        }
        if (node.right != null) {
            m2 += dfs(node.right.left, map) + dfs(node.right.right, map);
        }
        int ret = Math.max(m1, m2);
        map.put(node, ret);
        return ret;
    }
}
