package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 广度遍历
 */
public class E637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<Double> ret = new ArrayList<>();

        while (!list.isEmpty()) {
            double sum = 0;
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : list) {
                sum += node.val;
                if (node.left != null) {
                    newList.add(node.left);
                }
                if (node.right != null) {
                    newList.add(node.right);
                }
            }
            ret.add(sum / list.size());
            list = newList;
        }
        return ret;
    }
}
