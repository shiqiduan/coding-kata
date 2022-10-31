package com.duan.leetcode;

import java.util.*;

public class S133 {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> traveled = new HashSet<>();
        Node clone = new Node(node.val);
        map.put(node.val, clone);

        travel(node, traveled, map, clone);

        return clone;
    }

    private void travel(Node node, Set<Integer> traveled, Map<Integer, Node> map, Node clone) {
        if(traveled.contains(node.val)) {
            return;
        }
        traveled.add(node.val);

        for (Node s : node.neighbors) {
            Node sClone = map.get(s.val);
            if(sClone == null) {
                sClone = new Node(s.val);
                map.put(s.val, sClone);
            }
            travel(s, traveled, map, sClone);
            clone.neighbors.add(sClone);
        }
    }

    static final class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}