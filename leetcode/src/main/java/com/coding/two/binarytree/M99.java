package com.coding.two.binarytree;

import com.coding.TreeNode;

public class M99 {
    private TreeNode a;
    private TreeNode b;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (prev != null) {
            if (node.val < prev.val) {
                if (a == null) {
                    a = prev;
                }
                b = node;
            }
            System.out.println(node.val);
        }
        prev = node;
        dfs(node.right);
    }
}
