package com.coding.easytwo;

import com.coding.TreeNode;

public class E112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return track(root, targetSum);
    }

    private boolean track(TreeNode node, int targetSum) {
        if (node == null) {
            return targetSum == 0;
        }
        targetSum -= node.val;
        if (node.left == null && node.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(node.left, targetSum)
                || hasPathSum(node.right, targetSum);
    }
}
