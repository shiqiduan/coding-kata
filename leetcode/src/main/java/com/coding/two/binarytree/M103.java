package com.coding.two.binarytree;

import com.coding.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> levels = new ArrayList<>();
        levels.add(root);
        boolean forward = true;
        while (!levels.isEmpty()) {
            List<TreeNode> newLevels = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < levels.size(); i++) {
                TreeNode node = levels.get(i);
                if (node.left != null) {
                    newLevels.add(node.left);
                }
                if (node.right != null) {
                    newLevels.add(node.right);
                }

                temp.add(node.val);
            }
            if (forward) {
                ans.add(temp);
            } else {
                Collections.reverse(temp);
                ans.add(temp);
            }
            forward = !forward;
            levels = newLevels;
        }
        return ans;
    }
}
