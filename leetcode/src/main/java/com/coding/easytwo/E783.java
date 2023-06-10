package com.coding.easytwo;

import com.coding.TreeNode;

public class E783 {
    private Integer prev;
    private int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (prev != null) {
            ans = Math.min(ans, Math.abs(prev - node.val));
        }
        prev = node.val;
        dfs(node.right);
    }
}
