package com.coding;

public class E559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        int ret = 0;
        for (int i = 0; i < root.children.size(); i++) {
            ret = Math.max(ret, maxDepth(root.children.get(i)));
        }
        return ret + 1;
    }
}
