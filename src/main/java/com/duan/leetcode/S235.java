package com.duan.leetcode;

public class S235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;

        if(p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        if(p.val < root.val && q.val > root.val) {
            return root;
        }
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
