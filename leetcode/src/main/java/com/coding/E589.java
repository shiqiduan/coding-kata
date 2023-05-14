package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        track(root, result);
        return result;
    }

    private void track(Node node, List<Integer> ret) {
        if (node == null) return;
        ret.add(node.val);
        for (Node n : node.children) {
            track(n, ret);
        }
    }
}
