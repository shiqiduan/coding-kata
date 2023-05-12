package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int m = minDepth(root.left);
        int n = minDepth(root.right);
        if (root.right != null && root.left != null) {
            return Math.min(m, n) + 1;
        }
        return m + n + 1;
    }


    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int ret = 1;
        while (!list.isEmpty()) {
            List<TreeNode> newList = new ArrayList<TreeNode>();
            for (TreeNode child : list) {
                TreeNode left = child.left;
                TreeNode right = child.right;
                if (left == null && right == null) {
                    return ret;
                }
                if (left != null) {
                    if (left.left == null && left.right == null) {
                        return ret + 1;
                    }
                    newList.add(left);
                }
                if (right != null) {
                    if (right.right == null && right.left == null) {
                        return ret + 1;
                    }
                    newList.add(right);
                }
            }
            ret++;
            list = newList;
        }
        return ret;
    }
}
