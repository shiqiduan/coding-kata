package com.coding.two;

import com.coding.TreeNode;

public class E110 {
    private boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return ans;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        int l = getHeight(node.left);
        int r = getHeight(node.right);

        if (Math.abs(l - r) > 1) {
            ans = false;
        }
        return Math.max(l, r) + 1;
    }

}
