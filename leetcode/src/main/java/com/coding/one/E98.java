package com.coding.one;

import com.coding.TreeNode;

public class E98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long) (Integer.MIN_VALUE) - 1, (long) (Integer.MAX_VALUE) + 1);
    }

    private boolean isValidBST(TreeNode node, Long min, Long max) {
        if (node == null) return true;

        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, (long) node.val) && isValidBST(node.right, (long) node.val, max);
    }
}
