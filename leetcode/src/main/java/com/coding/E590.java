package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        track(root, result);
        return result;
    }

    private void track(Node node, List<Integer> result) {
        if (node == null) return;
        for (Node n : node.children) {
            track(n, result);
        }
        result.add(node.val);
    }
}
