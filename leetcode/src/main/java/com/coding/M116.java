package com.coding;

public class M116 {
    public Node1 connect(Node1 root) {
        if (root == null) return root;
        if (root.left == null) return root;
        Node1 current = root, left = current.left;

        Node1 prev = null;
        while (current != null) {
            if (prev != null) {
                prev.next = current.left;
            }
            prev = current.right;
            current.left.next = current.right;
            current = current.next;
        }
        connect(left);
        return root;
    }
}

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {
    }

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
