package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        TreeNode xNode = dfs(root, null, x, 0, map, parentMap);
        TreeNode yNode = dfs(root, null, y, 0, map, parentMap);

        return map.get(x) == map.get(y) && !parentMap.get(x).equals(parentMap.get(y));
    }

    private TreeNode dfs(TreeNode root, TreeNode parent, int x, int depth,
                         Map<Integer, Integer> map, Map<Integer, TreeNode> parentMap) {
        if(root == null) return null;
        if(root.val == x) {
            map.put(x, depth);
            parentMap.put(x, parent);
            return root;
        }
        TreeNode node = dfs(root.left, root, x, depth + 1, map, parentMap);
        if(node == null) {
            node = dfs(root.right, root, x, depth + 1, map, parentMap);
        }
        return node;
    }
}
