package com.coding;

public class E530 {
    int min = Integer.MAX_VALUE;
    int last = -1;

    public int getMinimumDifference(TreeNode root) {
        track(root);
        return min;
    }

    private void track(TreeNode node) {
        if (node.left != null) {
            track(node.left);
        }

        if (last != -1) {
            min = Math.min(min, Math.abs(node.val - last));
        }
        last = node.val;

        if (node.right != null) {
            track(node.right);
        }
    }
}
