package com.coding.two.binarytree;

import com.coding.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E501 {
    private int max;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                ans.add(entry.getKey());
            }
        }
        return ans.stream().mapToInt(value -> value).toArray();
    }

    private void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return;

        max = Math.max(max, map.getOrDefault(node.val, 0) + 1);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        dfs(node.left, map);
        dfs(node.right, map);
    }
}
