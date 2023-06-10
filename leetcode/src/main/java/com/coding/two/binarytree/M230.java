package com.coding.two.binarytree;

import com.coding.TreeNode;

public class M230 {
    private int p = 0;
    private int ans = 0;

    /**
     * 中序遍历
     */
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) return;

        dfs(node.left, k);
        p++;
        if (p == k) {
            ans = node.val;
        }
        dfs(node.right, k);
    }
}
