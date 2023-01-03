package com.duan.leetcode;

public class S112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return dfs(root, targetSum, false);
    }

    private boolean dfs(TreeNode node, int targetSum, boolean found) {
        if(found) return true;
        if(node == null) return false;
        if(node.left == null && node.right == null) {
            System.out.println(node.val + " " + targetSum);
            return targetSum == node.val;
        }

        found = dfs(node.left, targetSum - node.val, false);
        return dfs(node.right, targetSum - node.val, found);
    }
}
