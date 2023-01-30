package com.coding;

public class E530 {
    private Integer last;
    private int ret = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        track(root);
        return ret;
    }

    private void track(TreeNode node) {
        if (node == null) return;

        track(node.left);
        if (last == null) {
            last = node.val;
        } else {
            ret = Math.abs(Math.min(ret, node.val - last));
            last = node.val;
        }
        track(node.right);
    }
}
