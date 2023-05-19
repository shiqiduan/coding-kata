package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M114 {
    public void flatten(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        flatten(root, nodes);
        for (int i = 0; i < nodes.size() - 1; i++) {
            TreeNode n = nodes.get(i);
            n.left = null;
            n.right = nodes.get(i + 1);
        }
    }

    private void flatten(TreeNode node, List<TreeNode> nodes) {
        if (node == null) return;
        nodes.add(node);
        flatten(node.left, nodes);
        flatten(node.right, nodes);
    }
}
