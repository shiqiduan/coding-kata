package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class M199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> ret = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ret.add(queue.get(queue.size() - 1).val);

            List<TreeNode> tempQueue = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.get(i);
                if (node.left != null) {
                    tempQueue.add(node.left);
                }
                if (node.right != null) {
                    tempQueue.add(node.right);
                }
            }
            queue = tempQueue;
        }
        return ret;
    }
}
