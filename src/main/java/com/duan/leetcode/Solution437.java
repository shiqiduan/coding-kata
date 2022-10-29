package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 */
public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    private int rootSum(TreeNode node, long targetSum) {
        if(node == null) return 0;

        int times = 0;
        if(node.val == targetSum) {
            times++;
        }
        times += rootSum(node.left, targetSum - node.val);
        times += rootSum(node.right, targetSum - node.val);
        return times;
    }

    public int pathSum2(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(prefix, root, 0, targetSum);
    }

    private int dfs(Map<Long, Integer> prefix, TreeNode node, long curr, int targetNum) {
        if(node == null) return 0;

        int times = 0;
        curr += node.val;
        times = prefix.getOrDefault(curr - targetNum, 0);

        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        times += dfs(prefix, node.left, curr, targetNum);
        times += dfs(prefix, node.right, curr, targetNum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return times;
    }
}
