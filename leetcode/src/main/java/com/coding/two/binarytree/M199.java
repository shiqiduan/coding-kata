package com.coding.two.binarytree;

import com.coding.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode node, int level, List<Integer> ans) {
        if (node == null) return;
        if (ans.size() - 1 < level) {
            ans.add(node.val);
        } else {
            ans.set(level, node.val);
        }
        dfs(node.left, level + 1, ans);
        dfs(node.right, level + 1, ans);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        System.out.println(list);
    }
}
