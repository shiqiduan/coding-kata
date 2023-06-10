package com.coding.easytwo;

import com.coding.TreeNode;

public class E110 {
    public boolean isBalanced(TreeNode root) {
        return height(root)[0] == 1;
    }

    private int[] height(TreeNode node) {
        if (node == null) return new int[]{1, 0};
        int[] la = height(node.left);
        int[] ra = height(node.right);

        int h = Math.max(la[1], ra[1]) + 1;
        int flag = la[0] & ra[0] & ((Math.abs(la[1] - ra[1]) <= 1) ? 1 : 0);

        System.out.println(node.val + " " + h + " " + flag);
        return new int[]{flag, h};
    }

}
