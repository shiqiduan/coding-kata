package com.coding;

public class M230 {
    private int index = 0;
    private int ans = 0;
    private boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode node, int k) {
        if (found) return;
        if (node == null) return;
        kthSmallest(node.left, k);
        System.out.println(node);
        index++;
        if (index == k) {
            ans = node.val;
        }
        kthSmallest(node.right, k);
    }
}
