package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class E559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        List<Node> list = new ArrayList<>();
        list.add(root);
        int depth = 0;

        while (!list.isEmpty()) {
            depth++;
            List<Node> newList = new ArrayList<>();
            for (Node n : list) {
                newList.addAll(n.children);
            }
            list = newList;
        }
        return depth;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
