package com.coding.two;

import com.coding.TreeNode;

public class E543 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max - 1;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
