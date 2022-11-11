package com.duan.leetcode;

public class E938 {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        track(root, low, high);
        return sum;
    }

    private void track(TreeNode node, int low, int high) {
        if(node == null) return;

        if(node.val >= low && node.val <= high) {
            sum += node.val;
        }
        track(node.left, low, high);
        track(node.right, low, high);
    }
}
