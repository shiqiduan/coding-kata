package com.duan.leetcode;

public class S111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return bfs(root, Integer.MAX_VALUE, 0);
    }

    private Integer bfs(TreeNode node, Integer min, Integer depth) {
        if(depth > min) return min;
        if (node == null) {
            return min;
        }
        if(node.left == null && node.right == null) {
            return Math.min(min, depth + 1);
        }
        int tempMin;
        tempMin = bfs(node.left, min, depth + 1);
        tempMin = bfs(node.right, tempMin, depth + 1);
        return tempMin;
    }
}
