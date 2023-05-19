package com.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<TreeNode> level = new ArrayList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> newLevel = new ArrayList<TreeNode>();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                TreeNode node = level.get(i);
                if (node.left != null) {
                    newLevel.add(node.left);
                }
                if (node.right != null) {
                    newLevel.add(node.right);
                }
                temp.add(level.get(i).val);
            }
            ans.add(temp);
            level = newLevel;
        }
        Collections.reverse(ans);
        return ans;
    }
}
