package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> levels = new ArrayList<TreeNode>();
        levels.add(root);
        List<Double> ret = new ArrayList<Double>();
        while (levels.size() > 0) {
            long sum = 0, t = 0;
            List<TreeNode> newLevels = new ArrayList<TreeNode>();
            for (int i = 0; i < levels.size(); i++) {
                TreeNode n = levels.get(i);
                sum += n.val;
                t++;
                if (n.left != null) {
                    newLevels.add(n.left);
                }
                if (n.right != null) {
                    newLevels.add(n.right);
                }
            }
            ret.add(sum * 1.0 / t);
            levels = newLevels;
        }
        return ret;
    }
}
