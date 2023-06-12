package com.coding.easytwo;

import com.coding.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, ans, list);
        return ans;
    }

    private void dfs(TreeNode node, List<String> ans, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i);
                sb.append("->");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
            list.remove(list.size() - 1);
            return;
        }
        list.add(node.val);
        dfs(node.left, ans, list);
        dfs(node.right, ans, list);
        list.remove(list.size() - 1);
    }
}
