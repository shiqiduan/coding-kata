package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        track(root, result);
        return result;
    }

    private void track(TreeNode node, List<Integer> list) {
        if (node == null) return;
        track(node.left, list);
        track(node.right, list);
        list.add(node.val);
    }
}
