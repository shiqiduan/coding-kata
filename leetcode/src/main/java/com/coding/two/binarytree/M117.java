package com.coding.two.binarytree;

public class M117 {
    public Node connect(Node root) {
        if (root == null) return root;

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        if (root.left != null && root.right == null) {
            root.left.next = getNext(root.next);
        }

        if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node node) {
        if (node == null) return null;
        if (node.left != null) return node.left;
        if (node.right != null) return node.right;
        if (node.next != null) return getNext(node.next);
        return null;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
