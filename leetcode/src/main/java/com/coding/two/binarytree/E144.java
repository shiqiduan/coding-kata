package com.coding.two.binarytree;

import com.coding.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class E144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                ans.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
        return ans;
    }


    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        track(root, result);
        return result;
    }

    private void track(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        track(node.left, list);
        track(node.right, list);
    }
}
