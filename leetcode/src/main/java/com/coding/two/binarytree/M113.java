package com.coding.two.binarytree;

import com.coding.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> list, List<List<Integer>> ans) {
        targetSum = targetSum - node.val;

        if (node.left == null && node.right == null) {
            list.add(node.val);
            if (targetSum == 0) {
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        if (node.left != null) {
            list.add(node.val);
            dfs(node.left, targetSum, list, ans);
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            list.add(node.val);
            dfs(node.right, targetSum, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
