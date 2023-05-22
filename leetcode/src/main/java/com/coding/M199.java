package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            ans.add(level.get(level.size() - 1).val);
            List<TreeNode> newLevel = new ArrayList<>();
            for (TreeNode node : level) {
                if (node.left != null) {
                    newLevel.add(node.left);
                }
                if (node.right != null) {
                    newLevel.add(node.right);
                }
            }
            level = newLevel;
        }
        return ans;
    }
}
