package com.coding.two.binarytree;

import com.coding.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> newLevel = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                TreeNode node = level.get(i);
                temp.add(node.val);
                if (node.left != null) {
                    newLevel.add(node.left);
                }
                if (node.right != null) {
                    newLevel.add(node.right);
                }
            }
            level = newLevel;
            ans.add(temp);
        }
        return ans;
    }
}
