package com.coding.three;

import com.coding.TreeNode;

public class M114 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        if (left != null) {
            root.right = left;
            TreeNode curr = left;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = right;
        }
    }
}
