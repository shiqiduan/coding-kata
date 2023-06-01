package com.coding;

import java.util.HashMap;
import java.util.Map;

public class M662 {
    Map<Integer, Integer> levelMin = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    private int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index);
        return Math.max(index - levelMin.get(depth) + 1,
                Math.max(dfs(node.left, depth + 1, index * 2),
                        dfs(node.right, depth + 1, index * 2 + 1)));
    }
}
