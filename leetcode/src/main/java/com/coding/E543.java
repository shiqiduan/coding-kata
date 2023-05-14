package com.coding;

public class E543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        int left = (node.left != null) ? dfs(node.left) + 1 : 0;
        int right = (node.right != null) ? dfs(node.right) + 1 : 0;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
