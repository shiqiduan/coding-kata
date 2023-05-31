package com.coding;

public class M437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int ret = rootPath(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    private int rootPath(TreeNode node, long targetSum) {
        if (node == null) return 0;

        int ret = 0;
        targetSum -= node.val;
        if (targetSum == 0) {
            ret++;
        }

        ret += rootPath(node.left, targetSum);
        ret += rootPath(node.right, targetSum);
        return ret;
    }
}
