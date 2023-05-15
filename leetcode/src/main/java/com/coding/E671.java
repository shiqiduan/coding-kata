package com.coding;

public class E671 {
    public int findSecondMinimumValue(TreeNode root) {
        int second = dfs(root, root.val);
        return (dfs(root, root.val) != root.val) ? second : -1;
    }

    private int dfs(TreeNode node, int min) {
        if (node.left == null && node.right == null) return node.val;

        int left = (node.left != null && node.left.val == min) ? dfs(node.left, min) : node.left.val;
        int right = (node.right != null && node.right.val == min) ? dfs(node.right, min) : node.right.val;

        int second = Math.min(left, right);
        return (second == min) ? Math.max(left, right) : second;
    }
}
