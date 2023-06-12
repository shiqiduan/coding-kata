package com.coding.two.binarytree;

import com.coding.TreeNode;

public class M222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        if (lh == rh) {
            return (1 << lh) + countNodes(root.right);
        } else {
            return (1 << rh) + countNodes(root.left);
        }
    }

    private int getHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            node = node.left;
            h++;
        }
        return h;
    }
}
