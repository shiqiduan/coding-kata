package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E671 {
    public int findSecondMinimumValue(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int ret = 0;

        while (!list.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : list) {
                if (node.val == root.val) {
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                } else {
                    if (ret == 0) {
                        ret = node.val;
                    } else {
                        ret = Math.min(ret, node.val);
                    }
                }
            }
            list = temp;
        }
        return (ret == 0) ? -1 : ret;
    }
}
