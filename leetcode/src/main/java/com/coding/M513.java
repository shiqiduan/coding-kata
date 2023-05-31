package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M513 {
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        int ans = root.val;
        while (!level.isEmpty()) {
            List<TreeNode> newLevel = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                TreeNode n = level.get(i);
                if (n.left != null) {
                    newLevel.add(n.left);
                }
                if (n.right != null) {
                    newLevel.add(n.right);
                }
            }
            level = newLevel;
            if (!newLevel.isEmpty()) {
                ans = newLevel.get(0).val;
            }
        }
        return ans;
    }
}
