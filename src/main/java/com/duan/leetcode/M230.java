package com.duan.leetcode;

import java.util.*;

public class M230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pollLast();
            --k;
            if(k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }


    public int kthSmallest01(TreeNode root, int k) {
        TreeNode kNode = new TreeNode();
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("count", 0);
        track(root, k, kNode, countMap,false);
        return kNode.val;
    }

    private void track(TreeNode node, int k, TreeNode kNode, Map<String, Integer> countMap, boolean found) {
        if(found) return ;
        if(node == null) return;

        track(node.left, k, kNode, countMap, found);
        countMap.put("count", countMap.get("count") + 1);
        if(countMap.get("count") == k) {
            kNode.val = node.val;
            found = true;
        }
        track(node.right, k, kNode, countMap, found);
    }
}
