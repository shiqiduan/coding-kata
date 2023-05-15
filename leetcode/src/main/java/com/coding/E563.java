package com.coding;

public class E563 {

    private int ret = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return ret;
        nodeSum(root);
        return ret;
    }

    private int nodeSum(TreeNode node) {
        if (node == null) return 0;
        int left = nodeSum(node.left);
        int right = nodeSum(node.right);
        ret += Math.abs(left - right);
        return left + right + node.val;
    }
}
