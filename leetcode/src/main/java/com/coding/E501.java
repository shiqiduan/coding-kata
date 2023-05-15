package com.coding;

import java.util.HashSet;
import java.util.Set;

public class E501 {
    private TreeNode head;
    private TreeNode prev;
    int times = 1;
    int max = 1;

    public int[] findMode(TreeNode root) {
        if (root == null) return null;
        dfs(root);

        int tempTimes = 1;
        Set<Integer> set = new HashSet<Integer>();
        while (head != null) {
            if (head.left != null && head.val == head.left.val) {
                tempTimes++;
            } else {
                tempTimes = 1;
            }
            if (tempTimes == max) {
                System.out.println(head.val);
                set.add(head.val);
            }
            head = head.left;
        }

        int[] ret = new int[set.size()];
        int i = 0;
        for (Integer x : set) {
            ret[i] = x;
            i++;
        }
        return ret;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);

        if (head == null) {
            head = node;
            prev = node;
        } else {
            prev.left = node;

            if (node.val == prev.val) {
                times++;
                max = Math.max(max, times);
            } else {
                times = 1;
            }
            prev = node;
            node.left = null;
        }
        dfs(node.right);
    }
}
