package com.coding.two;

import com.coding.TreeNode;

public class E572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (equals(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean equals(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) return true;
        if (node != null && subRoot != null) {
            if (node.val == subRoot.val) {
                return equals(node.left, subRoot.left) && equals(node.right, subRoot.right);
            }
        }
        return false;
    }

}
