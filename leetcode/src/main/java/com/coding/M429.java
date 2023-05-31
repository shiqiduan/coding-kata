package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Node> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<Node> newLevel = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                temp.add(level.get(i).val);
                List<Node> children = level.get(i).children;
                if (children == null || children.isEmpty()) {
                    continue;
                }
                newLevel.addAll(children);
            }
            level = newLevel;
            ans.add(temp);
        }
        return ans;
    }
}
