package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        preorder(root, ret);
        return ret;
    }

    private void preorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        preorder(node.left, list);
        preorder(node.right, list);
        list.add(node.val);
    }
}
