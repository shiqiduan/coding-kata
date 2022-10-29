package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        bfs(root, list);
        return list.get(k - 1);
    }

    private void bfs(TreeNode node, List<Integer> nums) {
        if(node == null) {
            return;
        }
        bfs(node.left, nums);
        nums.add(node.val);
        bfs(node.right, nums);
    }
}
