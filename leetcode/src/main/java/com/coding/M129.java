package com.coding;

public class M129 {
    public int sumNumbers(TreeNode root) {
        return track(root, 0);
    }

    private int track(TreeNode node, int path) {
        if (node == null) return 0;

        path = path * 10 + node.val;
        if (node.left == null && node.right == null) {
            return path;
        }
        return track(node.left, path) + track(node.right, path);
    }
}
