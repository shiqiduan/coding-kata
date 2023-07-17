package com.coding.three;

import com.coding.TreeNode;

public class M230 {
    private int n = 0;
    private int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        track(root, k);
        return ans;
    }

    private void track(TreeNode node, int k) {
        if (node == null) return;
        track(node.left, k);
        n++;
        if (n == k) {
            ans = node.val;
        }
        track(node.right, k);
    }
}
