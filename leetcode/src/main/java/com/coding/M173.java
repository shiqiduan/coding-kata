package com.coding;

import java.util.Stack;

public class M173 {
}

class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        cur = root;
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}