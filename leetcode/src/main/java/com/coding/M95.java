package com.coding;

import java.util.LinkedList;
import java.util.List;

public class M95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int s, int e) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (s > e) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> leftTrees = generateTrees(s, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, e);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    allTrees.add(curr);
                }
            }
        }
        return allTrees;
    }
}
