package com.coding.one;

import com.coding.TreeNode;

public class M1448 {
    private int ans = 0;

    public int goodNodes(TreeNode root) {
        tracks(root, Integer.MIN_VALUE);
        return ans;
    }

    private void tracks(TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) {
            ans++;
        }
        tracks(node.left, Math.max(node.val, max));
        tracks(node.right, Math.max(node.val, max));
    }
}
