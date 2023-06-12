package com.coding.one;

import com.coding.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = dfs(root);
        if (list.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return "[" + sb.toString() + "]";
    }

    private List<Integer> dfs(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return list;
        }
        list.add(node.val);
        list.addAll(dfs(node.left));
        list.addAll(dfs(node.right));
        return list;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2) return null;
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        return dfs(split, 0, split.length - 1);
    }

    private TreeNode dfs(String[] array, int x, int y) {
        if (x > y) return null;
        int rootValue = Integer.parseInt(array[x]);

        if (x == y) {
            return new TreeNode(rootValue);
        }
        TreeNode root = new TreeNode(rootValue);

        int i = x + 1;
        for (i = x + 1; i <= y; i++) {
            if (Integer.parseInt(array[i]) > rootValue) {
                break;
            }
        }
        root.left = dfs(array, x + 1, i - 1);
        root.right = dfs(array, i, y);
        return root;
    }
}
