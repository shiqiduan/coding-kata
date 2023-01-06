package com.duan.leetcode;

public class E701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST(root.right, val);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST(root.left, val);
            }
        }
        return root;
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode pos = root;
        while (pos != null) {
            if (val > pos.val) {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    return root;
                } else {
                    pos = pos.right;
                }
            } else {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    return root;
                } else {
                    pos = pos.left;
                }
            }
        }
        return root;
    }
}
