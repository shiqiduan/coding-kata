package com.coding.two.binarytree;

import com.coding.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M173 {
}

/**
 * 中序遍历
 */
class BSTIterator {

    private Deque<TreeNode> stack;
    private TreeNode curr;

    public BSTIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        curr = root;
    }

    public int next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        int ret = curr.val;
        //
        curr = curr.right;
        return ret;
    }

    public boolean hasNext() {
        return this.curr != null || !stack.isEmpty();
    }
}