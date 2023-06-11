package com.coding.easytwo;

import com.coding.TreeNode;

public class E404 {

    private int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves(root, false);
        return ans;
    }

    public void sumOfLeftLeaves(TreeNode node, boolean left) {
        if (node == null) return;
        if (left && node.left == null && node.right == null) {
            ans += node.val;
            return;
        }
        sumOfLeftLeaves(node.left, true);
        sumOfLeftLeaves(node.right, false);
    }
}
