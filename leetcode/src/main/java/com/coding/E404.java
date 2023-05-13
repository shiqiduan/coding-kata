package com.coding;

public class E404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean left) {
        if (node == null) return 0;

        if (left && node.left == null && node.right == null) {
            return node.val;
        }

        return sumOfLeftLeaves(node.left, true)
                + sumOfLeftLeaves(node.right, false);
    }
}
