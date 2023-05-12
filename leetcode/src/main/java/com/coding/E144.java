package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        track(root, result);
        return result;
    }

    private void track(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        track(node.left, list);
        track(node.right, list);
    }
}
