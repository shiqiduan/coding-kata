package com.duan.leetcode;

public class S543 {
    public int diameterOfBinaryTree(TreeNode root) {
        return bfs(root)[0];
    }

    private int[] bfs(TreeNode node) {
        if(node == null) {
            return new int[] {0, 0};
        }
        if(node.left == null && node.right == null) {
            return new int[] {0, 0};
        }
        int[] left = bfs(node.left);
        int[] right = bfs(node.right);

        int maxLeft = (node.left == null)? 0: left[1] + 1;
        int maxRight = (node.right == null)? 0: right[1] + 1;

        int currentMax = maxLeft + maxRight;

        currentMax = Math.max(currentMax, left[0]);
        currentMax = Math.max(currentMax, right[0]);

        return new int[] {currentMax, Math.max(maxLeft, maxRight)};
    }
}
