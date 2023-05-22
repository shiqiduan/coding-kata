package com.coding;

public class M236 {
    private TreeNode retNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, q, q);
        return retNode;
    }

    private int dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return 0;

        int ret = 0;
        if (node.val == p.val || node.val == q.val) {
            ret = 1;
        }
        ret = ret + dfs(node.left, p, q) + dfs(node.right, p, q);
        System.out.println(node.val + " " + ret);
        if (ret == 2 && retNode == null) {
            retNode = node;
        }
        return ret;
    }
}
