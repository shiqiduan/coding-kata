package com.coding.two.binarytree;

import com.coding.TreeNode;

public class M129 {
    private int sum;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int current) {
        if (node == null) return;

        current = current * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += current;
            return;
        }
        dfs(node.left, current);
        dfs(node.right, current);
    }
}
