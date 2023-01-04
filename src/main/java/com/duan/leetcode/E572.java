package com.duan.leetcode;

public class E572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        boolean ret = false;
        if (root.val == subRoot.val) {
            ret = equal(root, subRoot);
        }

        return ret || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean equal(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        return (a != null && b != null) && a.val == b.val && equal(a.left, b.left) && equal(a.right, b.right);
    }
}
