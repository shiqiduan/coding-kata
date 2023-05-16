package com.coding;

public class E965 {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode node, int val) {
        if (node == null) return true;
        return node.val == val && isUnivalTree(node.left, val) && isUnivalTree(node.right, val);
    }
}
