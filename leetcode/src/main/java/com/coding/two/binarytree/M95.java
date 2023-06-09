package com.coding.two.binarytree;

import com.coding.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M95 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int s, int e) {
        List<TreeNode> nodes = new ArrayList<>();
        if (s == e) {
            nodes.add(new TreeNode(s));
            return nodes;
        }
        if (s > e) {
            nodes.add(null);
            return nodes;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> leftNodes = generateTrees(s, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, e);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(s);
                    root.left = left;
                    root.right = right;
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }
}
