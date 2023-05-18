package com.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);

        while (!level.isEmpty()) {
            List<Integer> vals = new ArrayList<Integer>();
            List<TreeNode> temp = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                TreeNode node = level.get(i);
                vals.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            ret.add(vals);
            level = temp;
        }
        return ret;
    }
}
