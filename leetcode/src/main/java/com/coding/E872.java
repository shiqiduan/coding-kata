package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<Integer>();
        dfs(root1, l1);
        List<Integer> l2 = new ArrayList<Integer>();
        dfs(root2, l2);
        return l1.equals(l2);
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
