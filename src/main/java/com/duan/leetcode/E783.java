package com.duan.leetcode;

public class E783 {
    private int prev;
    private int gap;

    public int minDiffInBST(TreeNode root) {
        gap = Integer.MAX_VALUE;
        prev = -1;
        bfs(root);
        return gap;
    }

    private void bfs(TreeNode node) {
        if (node == null) return;

        bfs(node.left);

        if (prev == -1) {
            prev = node.val;
        } else {
            gap = Math.min(gap, Math.abs(node.val - prev));
            prev = node.val;
        }
        bfs(node.right);
    }
}
