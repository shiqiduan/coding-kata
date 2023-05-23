package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        track(root, targetSum, path, ans);
        return ans;
    }

    private void track(TreeNode node, int target, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) return;

        target = target - node.val;
        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (target == 0) {
                ans.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        track(node.left, target, path, ans);
        track(node.right, target, path, ans);
        path.remove(path.size() - 1);
    }
}
