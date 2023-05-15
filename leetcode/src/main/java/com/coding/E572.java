package com.coding;

public class E572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;

        if (root != null && subRoot != null) {
            return (root.val == subRoot.val && equals(root.left, subRoot.left) && equals(root.right, subRoot.right))
                    || isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
        }
        return false;
    }

    private boolean equals(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a != null && b != null) {
            return a.val == b.val && equals(a.left, b.left) && equals(a.right, b.right);
        }
        return false;
    }
}
