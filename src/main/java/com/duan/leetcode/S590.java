package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S590 {
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        track(root, ret);
        return ret;
    }

    private void track(Node node, List<Integer> ret) {
        if(node == null) return;

        for (Node s : node.children) {
            track(s, ret);
        }

        ret.add(node.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
