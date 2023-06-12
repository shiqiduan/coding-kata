package com.coding.two.binarytree;

import com.coding.TreeNode;

public class M450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        TreeNode current = root.right;
        while (current.left != null) {
            current = current.left;
        }

        root.right = deleteNode(root.right, current.val);
        root.val = current.val;
        return root;
    }
}
